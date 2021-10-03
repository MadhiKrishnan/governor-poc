FROM maven:3.6.0-jdk-11-slim AS build
LABEL maintainer=”madhi.krishnan@fyndna.com”

COPY src /governor/src
COPY pom.xml /governor
RUN mvn -f /governor/pom.xml clean package

FROM tomcat
COPY --from=build /governor/target/governor.war /usr/local/tomcat/webapps/
EXPOSE 8080

CMD ["catalina.sh", "run"]
