FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD weather/app/target/*.jar app.jar
