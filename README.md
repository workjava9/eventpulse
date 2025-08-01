# eventpulse

Enterprise-уровня pet-проект для сбора, хранения и аналитики пользовательских событий в реальном времени.

## ️ Технологии

- Java 17 + Spring Boot 3
- Kafka, Redis, PostgreSQL
- Spring Security + JWT
- JPA + Liquibase
- Prometheus + Grafana (мониторинг)
- Docker Compose (локальное окружение)
- JUnit 5, Testcontainers, Mockito

##  Быстрый старт

1. Соберите JAR:
```bash
./gradlew clean build
```

2. Запустите всё через Docker:
```bash
docker compose down -v
docker compose up --build
```


##  Авторизация

- POST `/auth/login`:
```json
{
  "username": "test",
  "password": "test"
}
```
- Используйте токен в заголовке:
```
Authorization: Bearer <accessToken>
```

##  Отправка события

POST `/events`:
```json
{
  "type": "click",
  "metadata": {
    "page": "/home"
  }
}
```

##  Мониторинг

- Prometheus: [localhost:9090](http://localhost:9090)
- Grafana: [localhost:3000](http://localhost:3000)
- Kafka UI: [localhost:8085](http://localhost:8085)

##  Тесты

```bash
./gradlew test
```

##  Kafka топики

- `user-events` — события пользователей
- `user-events.dlq` — отложенные сообщения (dead-letter)

---



