FROM openjdk:8
EXPOSE 8080
ENV SPRING_RABBITMQ_ADDRESSES="amqp://rabbitmq:5672" MONGOCLIENT_DEFAULT_CONNECTION_URL="mongodb://mongo:27017/espark"
ADD /target/springboot-rabbitmqlistener-docker.jar springboot-rabbitmqlistener-docker.jar
ENTRYPOINT ["java","-jar","springboot-rabbitmqlistener-docker.jar"]