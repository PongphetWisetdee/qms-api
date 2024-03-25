FROM openjdk:17-jdk
VOLUME /tmp
ADD target/qms-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]