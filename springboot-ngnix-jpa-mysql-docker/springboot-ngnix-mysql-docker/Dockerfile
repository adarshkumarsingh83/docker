FROM openjdk:8
ADD target/springboot-ngnix-mysql-docker.jar springboot-ngnix-mysql-docker.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-ngnix-mysql-docker.jar" ,"-Dserver.port=9090"]