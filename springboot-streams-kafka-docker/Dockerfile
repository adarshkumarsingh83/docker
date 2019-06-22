FROM openjdk:8
ADD target/springboot-streams-kafka-docker.jar springboot-streams-kafka-docker.jar
EXPOSE 8080
ENV KAFKA_ADVERTISED_HOST_NAME:"localhost" KAFKA_ZOOKEEPER_CONNECT:"zookeeper:2181" KAFKA_DEFAULT_REPLICATION_FACTOR:"2"
ENTRYPOINT ["java","-jar","springboot-streams-kafka-docker.jar"]