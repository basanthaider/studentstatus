FROM openjdk:17
EXPOSE 8090
COPY . .
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]