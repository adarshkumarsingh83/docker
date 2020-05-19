FROM openjdk:8
ADD target/springboot-streams-rabbit-docker.jar springboot-streams-rabbit-docker.jar
ENV SPRING_RABBITMQ_ADDRESSES="amqp://rabbitmq:5672"
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-streams-rabbit-docker.jar"]