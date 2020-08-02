FROM openjdk:8
ADD target/springboot-cassandra.jar springboot-cassandra.jar
RUN apt-get update
RUN apt-get install -y curl
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-cassandra.jar"]