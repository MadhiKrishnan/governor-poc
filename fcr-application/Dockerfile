FROM openjdk:11-jre-slim
LABEL maintainer=”madhi.krishnan@fyndna.com”

ARG JAR_FILE=FCR_APPLICATION_JAR
COPY ${JAR_FILE} /usr/local/lib/fcr-application.jar
EXPOSE  8080
ENTRYPOINT ["java","-jar","/usr/local/lib/fcr-application.jar"]

