FROM gradle:8.7-jdk17 AS builder

WORKDIR /app
COPY . .

RUN gradle build -x test --no-daemon

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar notificacao.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "notificacao.jar"]