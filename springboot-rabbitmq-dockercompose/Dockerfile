FROM java:8
LABEL maintainer=adarshkumarsingh83@gmail.com
EXPOSE 8080
ENV SPRING_RABBITMQ_ADDRESSES="amqp://rabbitmq:5672"
WORKDIR /app
COPY /target/springboot-rabbitmq-dockercompose-1.0.0-SNAPSHOT.jar /app/spring-boot-app.jar
ENTRYPOINT ["java","-jar","spring-boot-app.jar"]
