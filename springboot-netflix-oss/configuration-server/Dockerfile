FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/configuration-server-1.0-SNAPSHOT.jar configuration-server-docker.jar
EXPOSE 8200
ENTRYPOINT ["java","-jar","configuration-server-docker.jar"]