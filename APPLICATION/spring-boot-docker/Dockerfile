FROM openjdk:8
ADD target/spring-boot-docker.jar spring-boot-docker.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","spring-boot-docker.jar"]
