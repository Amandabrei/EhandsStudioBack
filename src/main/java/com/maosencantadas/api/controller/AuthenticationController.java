package com.maosencantadas.api.controller;

import com.maosencantadas.infra.security.TokenService;
import com.maosencantadas.model.domain.user.AuthenticationDTO;
import com.maosencantadas.model.domain.user.LoginResponseDTO;
import com.maosencantadas.model.domain.user.RegisterDTO;
import com.maosencantadas.model.domain.user.User;
import com.maosencantadas.model.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    @Operation(summary = "User Login",
            description = "Authenticate a user and return a JWT token if successful.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successful, token returned"),
                    @ApiResponse(responseCode = "401", description = "Invalid login credentials")
            }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(summary = "User Registration",
            description = "Register a new user by providing login, password, and role.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User created successfully"),
                    @ApiResponse(responseCode = "400", description = "User with given login already exists"),
                    @ApiResponse(responseCode = "500", description = "Server error while saving user")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        if (repository.findByLogin(data.login()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Login already exists: " + data.login()));
        }

        try {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.login(), encryptedPassword, data.role());
            repository.save(newUser);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error saving user: " + e.getMessage()));
        }
    }
}
