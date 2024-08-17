FROM openjdk:17
EXPOSE 8090
RUN mvn clean package
COPY. .
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]