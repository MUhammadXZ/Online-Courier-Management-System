
FROM openjdk:11-jre-slim


WORKDIR /app


COPY target/spring-boot-docker.jar /app/spring-boot-docker.jar


CMD ["java", "-jar", "spring-boot-docker.jar"]
