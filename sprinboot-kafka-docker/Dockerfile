FROM openjdk:8
ADD target/sprinboot-kafka-docker.jar sprinboot-kafka-docker.jar
EXPOSE 8080
ENV KAFKA_ADVERTISED_HOST_NAME:"localhost" KAFKA_ZOOKEEPER_CONNECT:"zookeeper:2181" MONGOCLIENT_DEFAULT_CONNECTION_URL="mongodb://mongo:27017/espark"
ENTRYPOINT ["java","-jar","sprinboot-kafka-docker.jar"]