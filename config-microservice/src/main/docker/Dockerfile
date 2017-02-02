FROM java:8-jre-alpine
MAINTAINER Stefan Kruk

ADD @project.build.finalName@.jar app.jar

RUN sh -c 'touch /app.jar'

CMD ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]
