
# List Docker CLI commands
* $ docker
* $ docker container --help

### Display Docker version and info
* $ docker --version
* $ docker version
* $ docker info

----

### DOCKER IMAGE EXECUTION OPERATIONS
 
----

### To execute the docker image 
* $ docker run -p 9090:9090 <docker-image-name>
* -p for port 
* -d for background, in detached mode:

### EXAMPLE 
### to pull the mysql image to the local 
* $ docker pull mysql

### to run the mysql docker image 
* $ docker run --name <mysql-instance-name> -e MYSQL_ROOT_PASSWORD=<root-user-ped> 
* -e MYSQL_DATABASE=<mysql-db-name> -d mysql:<5.6]>

----
### DOCKER COMPOSE OPERATIONS
 
----
### to build 
* $ docker-compose build 

### To run a specific container first from docker-compose repete it for other in sequence 
* $ docker-compose up -d <'continer-name-in-file'>


### to start the docker
* $ docker-compose up

### To bring the docker container down 
* $ docker-compose down

### to know the process of the docker
* $ docker-compose ps

----
### DOCKER TAG CREATION OPERATIONS 
---- 

### To create a docker tag 
* $ docker tag image username/repository:tag . 
* $ docker -t <docker-tag-name> adarshkumarsingh83/repository:<docker-tag-name> . 
* or 
* $ docker build -f Dockerfile -t <docker-tag-name> .

----
### DOCKER IMAGE PUSH & PULL OPERATIONS
 
----

### To push the docker image to the docker hub 
* $ docker push username/repository:tag
* $ docker login --username=adarshkumarsingh83 --email=adarshkumarsingh83@gamail.com
* $ docker build -f Dockerfile -t <docker-tag-name> .
* $ docker images
* $ docker push adarshkumarsingh83/<repository-name>

### To pulling docker image from docker hub repository 
* $ docker pull adarshkumarsingh83/<repository-name>

----

### DOCKER CONTAINER OPERATIONS 

----
### List Docker containers (running, all, all in quiet mode)
* $ docker container ls
* $ docker container ls --all
* $ docker container ls -aq

### to clean the images one by one
* $ docker container rm <image id>

### to stop the running container
* $ docker container stop $(docker container ls -aq)

### to remove the containers
* $ docker container rm $(docker container ls -aq)

### Remove specified container from this machine
* $ docker container rm <docker container id>

### To Gracefully stop the particular container 
* $ docker stop <docker container id>

### Force shutdown of the specified container
* $ docker container kill <docker container id>

### To kill all the running container 
* $ docker kill $(docker ps -q)

### Docker container 
* docker ps -a 

###  docker continer 
* docker start <'continer-id'>
* docker stop <'continer-id'>

----

### DOCKER IMAGE OPERATIONS
 
----

### to list the local docker images 
* $ docker images
* $ docker image ls

### to know the list of images
* $ docker images --all

### Remove specified image from this machine
* $ docker image rm <image id>

### Remove all images from this machine
* $ docker image rm $(docker image ls -a -q)  

### to clean the images from docker
* $ docker system prune -f

### to remove the images from the docker
* $ docker image prune -a --filter "until=12m"

### to remove all the images 
* $ docker rmi $(docker images -a -q)

----

### DOCKER IMAGE ARCHIVE OPERATIONS 

----

### To save the docker image to archive 
* $ docker save docker-tag-name > docker-image-archive-name.tar

### To get the docker image from the archive 
* $ docker load --input <docker-image-archive-name>.tar
* $ docker images

----

### GETTING INTO THE DOCKER CONTAINER 

----
### to view the network list crated by docker
* $ docker network list

### to inspect docker network
* $ docker network inspect <network-name>
* OR
* $ docker inspect <container_name> | grep IPAddress

### to get inside container and execute the bash cmd 
* $ docker exec -it namenode /bin/bash

### To copy a fiel into the docker container 
* $ docker cp src/dir/file  <container-name>:destination/dir

----

### DOCKER LOGS OPERATION 

---

## To check logs 
* $ docker ps -a 
* $ docker logs <'contienrid'> 
