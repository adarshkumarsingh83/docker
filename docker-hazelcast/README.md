# SPRINGBOOT DOCKER HAZELCAST
> Descriptiion: \
> springboot application with hazelcast cache \
> docker compose 
>
>



### To Build the application 
* $ mvn clean package

### To execute the application 
* $ docker-compose up

### hazelcast management url 
* http://localhost:9090/hazelcast-mancenter

### To list the running docker containers
* $ docker ps


### To Get inside the hazelcast docker container
* $ docker exec -it <container name> /bin/bash
* $ docker exec -it hazelcast /bin/bash

### To list the container items
* bash-4.4# ls

### bash-4.4#  vi hazelcast.xml
````

 <group>
    <name>dev</name>
    <password>dev-pass</password>
 </group>
 <management-center enabled="true" update-interval="3">
     http://localhost:8080/hazelcast-mancenter
 </management-center>
````
* bash-4.4#  cat hazelcast.xml

### To restart the container
* $ docker restart

### To exit from the container
* $ exit

### TO BRING DOWN CONTAINERS 
* $ docker-compose down



