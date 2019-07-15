FROM openjdk:8
ADD target/springboot-elasticsearch-docker.jar springboot-elasticsearch-docker.jar
EXPOSE 8080
ENV ELASTICSEARCH_URL="http://localhost:9300"
ENTRYPOINT ["java","-jar","springboot-elasticsearch-docker.jar"]