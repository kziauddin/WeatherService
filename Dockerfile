FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
copy ./weather/webapp/target/webapp-0.0.1-SNAPSHOT.jar webapp-0.0.1-SNAPSHOT.jar
CMD ["java","-Dspring.profiles.active=local", "-jar","webapp-0.0.1-SNAPSHOT.jar"]
