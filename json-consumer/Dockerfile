FROM  openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} json-consumer.jar
ENTRYPOINT ["java", "-jar","json-consumer.jar"]