FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ComputeCSV-0.0.1.jar
ENTRYPOINT ["java","-jar","/ComputeCSV-0.0.1.jar"]