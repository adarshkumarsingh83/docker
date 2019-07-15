FROM openjdk:8
ADD target/springboot-elasticsearch-docker.jar springboot-elasticsearch-docker.jar
EXPOSE 9090
ENV ELASTICSEARCH_URL="http://localhost:9200"
ENTRYPOINT ["java","-jar","springboot-elasticsearch-docker.jar"]