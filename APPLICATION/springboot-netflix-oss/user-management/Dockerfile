FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/user-management-1.0-SNAPSHOT.jar user-management-server-docker.jar
EXPOSE 8400
ENTRYPOINT ["java","-jar","user-management-server-docker.jar"]