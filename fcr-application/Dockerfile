FROM maven:3.6.0-jdk-11-slim AS build
COPY fcr-application/src /home/fcr-application/src
COPY fcr-application/pom.xml /home/fcr-application
RUN mvn -f /home/fcr-application/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/fcr-application/target/fcr-application-0.0.1-SNAPSHOT.jar /usr/local/lib/fcr-application.jar
EXPOSE 8080 7002
ENTRYPOINT ["java","-jar","/usr/local/lib/fcr-application.jar"]

