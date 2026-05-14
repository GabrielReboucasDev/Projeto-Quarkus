# Biblioteca Pessoal

## Descrição
**Biblioteca Pessoal** é um projeto desenvolvido para gerenciamento de livros de uma biblioteca pessoal.

Este projeto foi desenvolvido para aprimorar os conhecimentos em:
- **Web API Rest**
- **Quarkus Framework**
- **Hibernate ORM com Panache**

## Autores
- **Gabriel Sousa Rebouças Freire**

## Tecnologias Utilizadas
- **Java 17** (Quarkus)
- **Quarkus RESTEasy** – Para criação da API REST
- **Hibernate ORM com Panache** – Para persistência de dados
- **Banco de dados H2 (em memória)**
- **SmallRye OpenAPI** (para documentação da API) / Swagger
- **Lombok** – Para redução de código boilerplate

## Estrutura do Projeto
O projeto segue a estrutura do **Quarkus**, com as seguintes dependências principais:
- **Quarkus-resteasy** – Para criação da API REST.
- **Quarkus-resteasy-jackson** – Para serialização/desserialização JSON.
- **Quarkus-hibernate-orm-panache** – Para persistência simplificada com Hibernate.
- **Quarkus-jdbc-h2** – Banco de dados em memória.
- **Quarkus-smallrye-openapi** – Para documentação da API via Swagger UI.
- **Quarkus-hibernate-validator** – Para validação de dados.
- **Lombok** – Para redução de código boilerplate.

## Como Utilizar
- Cadastrar novo livro: POST http://localhost:8080/project/livros
- Listar todos os livros: GET http://localhost:8080/project/livros
- Buscar livro por ID: GET http://localhost:8080/project/livros/{id}
- Atualizar livro: PUT http://localhost:8080/project/livros/{id}
- Deletar livro: DELETE http://localhost:8080/project/livros/{id}
