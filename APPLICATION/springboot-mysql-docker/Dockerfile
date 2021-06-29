FROM openjdk:8
ADD target/springboot-mysql-docker.jar springboot-mysql-docker.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-mysql-docker.jar"]