FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/springboot-postgres-docker.jar springboot-postgres-docker.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-postgres-docker.jar"]