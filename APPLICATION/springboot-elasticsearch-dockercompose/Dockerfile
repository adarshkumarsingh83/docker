FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/springboot-elasticsearch-dockercompose.jar springboot-elasticsearch.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-elasticsearch.jar"]