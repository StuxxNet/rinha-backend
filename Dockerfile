FROM openjdk:17-jdk-slim

COPY target/rinha-backend-0.0.1-SNAPSHOT.jar rinha-backend-1.0.0.jar

ENTRYPOINT ["java","-jar","/rinha-backend-1.0.0.jar"]