FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/zipkin-server-1.5.14.RELEASE.jar zipkin-server-docker.jar
EXPOSE 8300
ENTRYPOINT ["java","-jar","zipkin-server-docker.jar"]