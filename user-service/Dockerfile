FROM openjdk:17
EXPOSE 8080
COPY ./build/libs/user-service-plain.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]