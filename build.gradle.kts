plugins {
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.5"
    id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Web (REST API)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // JPA + Hibernate
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Валидация (@NotNull, @Email и т.п.)
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // H2 Database (in-memory DB)
    runtimeOnly("com.h2database:h2")

    // Swagger / OpenAPI UI
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // Тестирование
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}
