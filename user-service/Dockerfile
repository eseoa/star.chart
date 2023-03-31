FROM amazoncorretto:17.0.5-alpine
EXPOSE 8080
COPY ./build/libs/user-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]