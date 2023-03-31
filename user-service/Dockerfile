FROM openjdk:17
EXPOSE 8080
COPY ./build/libs/user-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]