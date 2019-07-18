FROM openjdk:8
ADD target/docker-hazelcast.jar docker-hazelcast.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","docker-hazelcast.jar"]