FROM openjdk:8-jdk-alpine
ADD ./target/springboot-rabbit-binder-producer.jar springboot-rabbit-binder-producer.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-rabbit-binder-producer.jar"]