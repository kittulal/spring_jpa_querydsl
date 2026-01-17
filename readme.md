# Spring Boot JPA – Dynamic Search with QueryDSL

This project demonstrates how to build dynamic search APIs using Spring Boot 3, Spring Data JPA, and QueryDSL.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- QueryDSL (Jakarta)
- Hibernate
- Gradle

## Features
- Employee–Department JPA mapping
- Dynamic filtering with QueryDSL
- Proper QueryDSL configuration
- Fixes for common pitfalls (Q classes, bean wiring, serialization)

## Project Structure
src/main/java
- config
- controller
- dto
- entity
- repository
- service

## Dependencies (Gradle)

```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-validation'

    implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
    annotationProcessor 'com.querydsl:querydsl-apt:5.0.0:jakarta'
    annotationProcessor 'jakarta.persistence:jakarta.persistence-api:3.1.0'

    runtimeOnly 'com.h2database:h2'
}
```

## QueryDSL Configuration

```java
@Configuration
public class QueryDslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
```

## Dynamic Search API

POST /api/employees/search

```json
{
  "firstName": "Alice",
  "email": "alice.johnson@company.com"
}
```

## Common Issues
- Cannot resolve QEmployee → enable annotation processing & rebuild
- NoClassDefFoundError jakarta.persistence.Entity → add jakarta.persistence-api to annotationProcessor
- contextLoads fails → ensure JPAQueryFactory bean exists

## Best Practices
- Do not expose JPA entities directly
- Use DTOs for API responses
- Prefer QueryDSL for complex dynamic queries

Happy Coding 🚀
