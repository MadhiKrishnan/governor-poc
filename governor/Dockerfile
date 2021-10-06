FROM tomcat

LABEL maintainer=”madhi.krishnan@fyndna.com”
ARG WAR_FILE=GOVERNOR_WAR

FROM tomcat
COPY  ${WAR_FILE} /usr/local/tomcat/webapps/
EXPOSE 9090

CMD ["catalina.sh", "run"]
