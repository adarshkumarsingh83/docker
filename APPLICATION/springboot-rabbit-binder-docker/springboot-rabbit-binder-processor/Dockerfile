FROM openjdk:8-jdk-alpine
ADD ./target/springboot-rabbit-binder-processor.jar springboot-rabbit-binder-processor.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","springboot-rabbit-binder-processor.jar"]