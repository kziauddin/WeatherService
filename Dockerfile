FROM openjdk:8-jdk-alpine
VOLUME /tmp
copy ./weather/weatherservice/target/weather.jar weather.jar
CMD ["java","-jar","weather.jar"]
