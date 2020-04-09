FROM openjdk:10-jre-slim
COPY ./target/maven-docker-plugin-1.0-SNAPSHOT.jar /usr/src/maven-docker-plugin/
WORKDIR /usr/src/maven-docker-plugin
EXPOSE 8080
CMD ["java", "-jar", "maven-docker-plugin-1.0-SNAPSHOT.jar"]