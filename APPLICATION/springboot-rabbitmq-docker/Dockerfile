FROM openjdk:8
EXPOSE 8080
ENV SPRING_RABBITMQ_ADDRESSES="amqp://rabbitmq:5672"
ADD /target/springboot-rabbitmq-docker.jar springboot-rabbitmq-docker.jar
ENTRYPOINT ["java","-jar","springboot-rabbitmq-docker.jar"]