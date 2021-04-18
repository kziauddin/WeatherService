FROM tomcat:8.0-alpine
LABEL maintainer=”kziauddin@gmail.com”
ADD src/main/webapp/TestWeather.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD [“catalina.sh”, “run”]