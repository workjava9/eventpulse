
# Real-time Event Analytics Platform

Java pet-проект уровня enterprise с Kafka, Redis, Spring Boot и JWT.

## Стек

- Java 17, Spring Boot 3
- Spring Web, Security, Kafka, Redis, JPA
- PostgreSQL + Liquibase
- JWT авторизация
- Docker Compose (Kafka, Redis, Postgres, Prometheus, Grafana)
- JUnit 5, Mockito, Testcontainers

## Запуск

1. Соберите проект:
```bash
./gradlew clean build
```

2. Запустите окружение:
```bash
cd Docker
docker compose up -d
```

3. Запустите приложение:
```bash
./gradlew bootRun
```

## Тестирование

```bash
./gradlew test
```

## Авторизация

1. POST `/auth/login`:
```json
{
  "username": "test",
  "password": "test"
}
```
2. Получите `accessToken` и используйте в `Authorization: Bearer <token>` заголовке.

## Отправка события

POST `/events`:
```json
{
  "type": "click",
  "metadata": {
    "page": "/home"
  }
}
```

## Топики Kafka
- `user-events` — события пользователей
- `user-events.dlq` — DLQ

## Мониторинг

- Prometheus: http://localhost:9090
- Grafana: http://localhost:3000
- Kafka UI: http://localhost:8085

