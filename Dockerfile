FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD weather/entity/target/*.jar entity.jar
ADD weather/common/target/*.jar common.jar
ADD weather/data/target/*.jar data.jar
ADD weather/app/target/*.jar app.jar
ADD weather/webapp/target/*.jar webapp.jar

