FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/eureka-server-1.0-SNAPSHOT.jar eureka-server-docker.jar
EXPOSE 8761
ENV REGISTRY_HOST=eureka-server
ENTRYPOINT ["java","-jar","eureka-server-docker.jar"]