FROM maven:3.9.4-amazoncorretto-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:21-ea-10-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar app.jar

ENTRYPOINT ["java", "-Dserver.port=80", "-jar", "/app/app.jar"]

EXPOSE 80