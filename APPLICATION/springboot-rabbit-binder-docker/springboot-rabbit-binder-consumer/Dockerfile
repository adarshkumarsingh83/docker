FROM openjdk:8-jdk-alpine
ADD ./target/springboot-rabbit-binder-consumer.jar springboot-rabbit-binder-consumer.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-rabbit-binder-consumer.jar"]