FROM openjdk:8-jdk-alpine
VOLUME /tmp
copy ./weather/webapp/target/webapp-0.0.1-SNAPSHOT webapp-0.0.1-SNAPSHOT
CMD ["java","-jar","webapp-0.0.1-SNAPSHOT"]
