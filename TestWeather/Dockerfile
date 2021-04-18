FROM tomcat:8.0-alpine
LABEL maintainer=”kziauddin@gmail.com”
ADD ./TestWeather.war /usr/local/tomcat/webapps/
copy ./TestWeather.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD [“catalina.sh”, “run”]