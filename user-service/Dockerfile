FROM openjdk:17
EXPOSE 8081
COPY ./build/libs/user-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]