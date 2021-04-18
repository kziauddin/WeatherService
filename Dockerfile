FROM openjdk:11-jdk-alpine
VOLUME /tmp
copy ./weather/webapp/target/webapp-0.0.1-SNAPSHOT.jar webapp-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","webapp-0.0.1-SNAPSHOT.jar"]
