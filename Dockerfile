FROM openjdk:15
ARG JAR_FILE=build/libs/alfa-bank-test-task-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

