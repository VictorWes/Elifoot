# Elifoot

Projeto backend em Java com Spring Boot para gerenciamento de usuários e outras funcionalidades relacionadas a futebol.

## Visão geral

Este repositório contém a API do Elifoot — um backend escrito em Java 17+ usando Spring Boot, Maven e migrações de banco de dados. O projeto inclui endpoints REST, validação de requests, camada de serviço e mapeadores para entidade/DTO.

## Tecnologias

- Java 17+
- Spring Boot
- Maven
- Flyway (migrações SQL armazenadas em src/main/resources/db/migration)
- JPA/Hibernate
- Lombok
- H2 (pode ser usado em memória para desenvolvimento) ou outro SGBD (Postgres, MySQL)

## Requisitos

- JDK 17 ou superior
- Maven 3.6+
- (Opcional) Docker e docker-compose

## Como configurar

1. Copie e ajuste as propriedades de conexão no arquivo `src/main/resources/application.yml` (ou `application.properties` se existir). Exemplo para H2 em memória:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:elifootdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false

# Flyway padrão usa src/main/resources/db/migration
```

2. Se for utilizar outro banco (Postgres, MySQL), altere a URL, driver, usuário e senha conforme necessário.

## Build

Gerar o artefato com Maven:

```
mvn clean package
```

O JAR gerado ficará em `target/elifoot-0.0.1-SNAPSHOT.jar`.

## Executando a aplicação

- A partir do jar gerado:

```
java -jar target/elifoot-0.0.1-SNAPSHOT.jar
```

- Ou execute a classe principal do Spring Boot pela sua IDE (IntelliJ, Eclipse).

- Usando Docker Compose (se houver serviço configurado no `docker-compose.yml`):

```
docker-compose up --build
```

## Testes

Executar testes unitários e de integração com:

```
mvn test
```

Relatórios de cobertura e resultados de teste podem estar disponíveis na pasta `target` (ex.: surefire-reports, jacoco).

## Endpoints principais

A API expõe vários endpoints. Exemplo do endpoint de criação de usuário:

- Criar usuário
  - Método: POST
  - URL: /users
  - Corpo (exemplo JSON):

```json
{
  "username": "usuario",
  "email": "email@exemplo.com",
  "password": "senhaSegura"
}
```

- Resposta esperada: 201 Created com o JSON do usuário criado (conforme `controller/response`).

Consulte os controladores em `src/main/java/com/java10x/elifoot/controller` para outros endpoints e formatos de request/response.

## Migrações de banco

As migrações estão em `src/main/resources/db/migration` (Flyway). Arquivos como `V1__create_initial_tables.sql` e `V2__create_table_user.sql` definem o esquema inicial.

## Boas práticas

- Validar entradas com anotações de validação (`@Valid`, `@NotNull`, `@Email`, etc.).
- Separar lógica de negócios em serviços e deixar controllers apenas para orquestração de requests/responses.
- Utilizar DTOs/Responses para não expor entidades diretamente.
- Manter migrações em ambiente produtivo (Flyway/Liquibase) em vez de `ddl-auto: update`.

## Variáveis de ambiente úteis

- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- SPRING_PROFILES_ACTIVE



