# Rewards Program

A REST API that calculates customer reward points based on purchase transactions over a 3-month period.

## Rewards Logic

- **$0 – $50** → 0 points
- **$50 – $100** → 1 point per dollar over $50
- **Above $100** → 50 points + 2 points per dollar over $100

> Example: $120 = (2 × $20) + (1 × $50) = **90 points**

## Tech Stack

Java 17, Spring Boot 3.2, Spring Data JPA, H2, Lombok, Swagger

## Run

```bash
mvn spring-boot:run
```

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/rewards/{customerId}` | Rewards for a customer |
| GET | `/api/rewards/all` | Rewards for all customers |

## Sample Response

```json
{
  "customerId": 1,
  "customerName": "Mehul",
  "monthlyRewards": {
    "2025-03": 110,
    "2025-04": 90,
    "2025-05": 0
  },
  "totalRewards": 200
}
```

## Useful URLs

| URL | Description |
|-----|-------------|
| `http://localhost:8080/swagger-ui.html` | Swagger UI |
| `http://localhost:8080/h2-console` | H2 Database Console |

> H2 Console — JDBC URL: `jdbc:h2:mem:rewardsdb` · Username: `sa` · Password: *(blank)*
