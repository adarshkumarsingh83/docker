FROM openjdk:8
ADD target/springboot-jpa-postgrace-docker.jar springboot-jpa-postgrace-docker.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-jpa-postgrace-docker.jar"]