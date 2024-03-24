FROM openjdk:17-jdk-slim

WORKDIR /

COPY build/libs/kafkaclientdemo-0.0.1-SNAPSHOT.jar .

LABEL authors="lynch"

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "kafkaclientdemo-0.0.1-SNAPSHOT.jar"]
