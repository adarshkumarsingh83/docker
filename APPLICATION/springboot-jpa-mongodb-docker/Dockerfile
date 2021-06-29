FROM openjdk:8
ADD target/springboot-jpa-mongodb-docker.jar springboot-jpa-mongodb-docker.jar
EXPOSE 8080
ENV MONGOCLIENT_DEFAULT_CONNECTION_URL = "mongodb://mongo:27017/employee"
ENTRYPOINT ["java","-jar","springboot-jpa-mongodb-docker.jar"]