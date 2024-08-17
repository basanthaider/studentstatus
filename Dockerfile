FROM openjdk:17
EXPOSE 8090
RUN mvn clean package
COPY . .
COPY --from=builder /app/target/*.jar app.jar
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]