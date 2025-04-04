FROM openjdk:17-alpine

WORKDIR /app

COPY build/libs/account-service-*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
