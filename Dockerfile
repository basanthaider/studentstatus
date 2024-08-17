FROM maven:3.8.6-jdk-17-slim AS builder
EXPOSE 8090
RUN mvn clean package
COPY . .
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]