FROM openjdk:8u111-jdk

WORKDIR application
ARG JAR_FILE=target/demo*.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]
