# docker-debugging.sh
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8090,suspend=n -jar springboot-h2-db-docker-remote-debugging.jar