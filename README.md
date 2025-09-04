# Wallet Service

Este é um projeto **Spring Boot** que implementa um serviço simples de carteira digital.

## Requisitos

- Java 21+
- Maven 3.8+

## Rodando a aplicação

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em: [http://localhost:8080]

## Endpoints principais

- `GET /wallets` → lista todas as carteiras
- `POST /wallets` → cria uma nova carteira
- `POST /wallets/{id}/withdraw` Saque
- `POST /wallets/{id}/deposit` Deposito
- `POST /wallets/{id}/balance` Saldo
- `POST /wallets/transfer` → transfere saldo entre carteiras

## Rodando os testes

```bash
mvn test
```
