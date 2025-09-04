# Wallet Service

Este é um projeto **Spring Boot** que implementa um serviço simples de carteira digital.

## Requisitos

- Java 17+
- Maven 3.8+

## Rodando a aplicação

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em: [http://localhost:8080](http://localhost:8080)

## Endpoints principais

- `GET /wallets` → lista todas as carteiras
- `POST /wallets` → cria uma nova carteira
- `POST /wallets/transfer` → transfere saldo entre carteiras

## Rodando os testes

```bash
mvn test
```

## Gerando relatório de cobertura (Jacoco)

O projeto está configurado com **Jacoco**. Para gerar o relatório, rode:

```bash
mvn verify
```

O relatório HTML estará disponível em:

```
target/site/jacoco/index.html
```

---

Autor: *Wallet Service Team*
