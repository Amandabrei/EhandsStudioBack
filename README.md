# EHands Studio (Mãos Encantadas)

Sistema backend desenvolvido em **Java** e **Spring Boot**, projetado com foco em arquitetura de software, separação de responsabilidades e boas práticas de desenvolvimento. O projeto aplica conceitos amplamente utilizados no mercado, como **Programação Orientada a Objetos (POO)**, **Princípios SOLID**, **Domain-Driven Design (DDD)** e **Arquitetura em Camadas**, visando a construção de uma aplicação escalável, organizada e de fácil manutenção. 

---

# Objetivo

O projeto foi desenvolvido com o objetivo de aplicar conceitos e práticas utilizadas em ambientes corporativos, proporcionando experiência na construção de APIs REST robustas, bem estruturadas.

## Principais conceitos aplicados

- Programação Orientada a Objetos (POO)
- Princípios SOLID
- Domain-Driven Design (DDD)
- Arquitetura em Camadas
- API REST
- Persistência de Dados com JPA/Hibernate
- Organização e padronização de código
- Separação de responsabilidades

---

# Planejamento do Projeto

Antes do início do desenvolvimento, foi realizado um processo de análise e modelagem para garantir uma estrutura sólida para a aplicação e de fãcil manuntenção.

## Levantamento de Requisitos e Casos de Uso

Inicialmente, foi elaborado um diagrama de casos de uso para mapear as funcionalidades do sistema e compreender a interação dos usuários com a aplicação.

Essa etapa foi fundamental para definir o comportamento esperado do sistema e orientar as decisões de implementação.


## Modelagem do Banco de Dados

Antes da implementação da aplicação, desenhei todas as tabelas e iniciei a modelagem do projeto, nessa fase gosto de fazer longe do ambiente de trabalho, gosto de usar papel e caneta e pensar como usuário do sistema e naõ como programadora.
Após isso começo definindo a estrutura do domínio e os relacionamentos necessários para o sistema.


---

# Desenvolvimento da Aplicação

## 1️⃣ Criação das Entidades

Com base na modelagem do banco de dados, foram criadas as entidades utilizando **JPA/Hibernate**.

Foram implementados:

- Atributos das entidades
- Relacionamentos entre objetos
- Chaves primárias
- Mapeamentos ORM
- Configurações de persistência

As entidades representam o núcleo do domínio da aplicação.

## 2️⃣ Implementação dos DTOs

Para evitar a exposição direta das entidades e aumentar a segurança da API, foram criados **DTOs (Data Transfer Objects)**.

### Benefícios

- Controle dos dados expostos
- Maior segurança
- Redução do acoplamento
- Facilidade para manutenção e evolução da API

## 3️⃣ Criação dos Mappers

Foram implementados Mappers responsáveis pela conversão entre entidades e DTOs.

Essa camada permitiu:

- Separação de responsabilidades
- Reutilização de código
- Melhor organização da aplicação
- Facilidade de manutenção

## 4️⃣ Implementação da Camada de Serviço (Services)

A camada Service foi desenvolvida para centralizar toda a lógica de negócio da aplicação.

Nela foram implementadas funcionalidades como:

- Validações
- Regras de negócio
- Processamento de dados
- Tratamento de exceções
- Comunicação com os repositórios

Seguindo os princípios do SOLID, os Services possuem responsabilidade exclusiva sobre as regras de domínio da aplicação.

## 5️⃣ Criação dos Repositórios

Os Repositories foram implementados utilizando **Spring Data JPA**, abstraindo toda a comunicação com o banco de dados.

### Responsabilidades

- Consultas
- Persistência de dados
- Atualizações
- Exclusões

Essa camada garante desacoplamento entre a lógica de negócio e a persistência.

## 6️⃣ Desenvolvimento dos Controllers

Os Controllers foram responsáveis pela exposição dos endpoints REST da aplicação.

### Funcionalidades

- Recebimento de requisições HTTP
- Validação de entradas
- Comunicação com a camada Service
- Retorno padronizado das respostas

Essa abordagem garante uma API organizada e alinhada às boas práticas REST.

## 7️⃣ Tratamento Global de Exceções

Foi implementada uma estratégia centralizada para tratamento de erros da aplicação.

### Benefícios

- Respostas padronizadas
- Melhor experiência para consumidores da API
- Facilidade de manutenção
- Maior previsibilidade dos retornos

---

# Arquitetura Utilizada

O projeto foi estruturado utilizando conceitos inspirados em **DDD (Domain-Driven Design)** e **Arquitetura em Camadas**.

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Complementado pelo fluxo:

```text
DTO ↔ Mapper ↔ Entity
```

### Benefícios da arquitetura

- Escalabilidade
- Testabilidade
- Manutenibilidade
- Baixo acoplamento
- Alta coesão

---

# Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- MySQL Workbench
- Maven
- REST API

---

# Aprendizados

Durante o desenvolvimento deste projeto, aprofundei conhecimentos em:

- Estruturação de APIs REST
- Arquitetura de Software
- Modelagem de Banco de Dados
- Programação Orientada a Objetos (POO)
- Princípios SOLID
- Domain-Driven Design (DDD)
- Separação de Responsabilidades
- Persistência de Dados com JPA/Hibernate
- Desenvolvimento Backend com Spring Boot
- Boas práticas de desenvolvimento e organização de código

---

# Considerações Finais

Este projeto representa a aplicação prática de conceitos fundamentais utilizados no desenvolvimento backend profissional, consolidando conhecimentos em arquitetura de software, organização de código e construção de aplicações escaláveis utilizando o ecossistema Spring.
