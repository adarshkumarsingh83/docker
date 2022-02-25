FROM openjdk:8
EXPOSE 8080 8000
ADD target/springboot-h2-db-docker-remote-debugging.jar springboot-h2-db-docker-remote-debugging.jar
ADD docker-debugging.sh docker-debugging.sh
ENTRYPOINT ["sh","/docker-debugging.sh"]