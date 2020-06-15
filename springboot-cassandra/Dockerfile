FROM openjdk:8
ADD target/springboot-cassandra.jar springboot-cassandra.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-cassandra.jar"]