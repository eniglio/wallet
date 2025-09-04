# Wallet Service

This is a **Spring Boot** project that implements a simple digital wallet service.

## Requirements

- Java 21+
- Maven 3.8+

## Running the application

```bash
mvn spring-boot:run
```

The application will be available at: [http://localhost:8080]

## Main endpoints

- `GET /wallets` lista todas as carteiras -> list all wallets
- `POST /wallets` cria uma nova carteira -> create a new wallet
- `POST /wallets/{id}/withdraw` Saque
- `POST /wallets/{id}/deposit` Deposito
- `POST /wallets/{id}/balance` Saldo
- `POST /wallets/transfer` transfere saldo entre carteiras -> transfer balance between wallets

## Running the tests

```bash
mvn test
```

### Springdoc OpenAPI

- `http://localhost:8080/swagger-ui.html`
