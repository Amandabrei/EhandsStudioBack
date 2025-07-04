package com.maosencantadas.model.repository;

import com.maosencantadas.model.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maosencantadas.model.domain.artist.Artist;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByCategoryId(Long categoryId);

    Optional<Artist> findByName(String artistName);

    Optional<Artist> findByUser(User user);


    //List<Artist> findByCategoryName(String categoryName);
}
