# spring boot cassandra db 
>Description: \
> spring boot application used spring data jpa \
> which uses cassandra db internally for data storage \
> to perform the curd operation.

----

### To build the application 
* $ mvn clean package 

#### DOWNLOAD CASSANDRA LOCALLY AND EXECUTION
---
````
Cassandra local
$ cd ~/workspace/tools/dse-xxxx/bin
$ ./dse cassandra
$ ./dse cassandra-stop

#to open cli
$ cd ~/workspace/tools/dse-xxx/bin

$ ./cqlsh localhost
cqlsh> create keyspace employee with replication = {'class':'SimpleStrategy','replication_factor':1};

cqlsh> describe keyspace espark;
cqlsh> select * from espark.employee;
cqlsh> Drop keyspace KeyspaceName

````
----
# To bring the docker container up standalone execution  
* $ docker run --name cassandra  -p 9042:9042 cassandra

### for docker cassandra shell
* $ docker exec -it cassandra cqlsh

### To Test the Application Execution 
* $ curl -X POST -H "Content-Type: application/json" -d '{"id":1, "name":"adarsh kumar"}' http://localhost:8080/api/employee
* $ curl http://localhost:8080/api/employee/1

### Docker clean up 
* $ docker stop $(docker ps -a -q)
* $ docker rm $(docker ps -a -q)

### TO LIST DOWN ALL THE IMAGES
* $ docker images

### TO LIST ALL THE PROCESS
* $ docker ps -a



----
### Docker compose execution 
* $ docker-compose up 
* $ docker-compose down

### To Test the Application Execution 
* $ curl -X POST -H "Content-Type: application/json" -d '{"id":1, "name":"adarsh kumar"}' http://localhost:8080/api/employee
* $ curl http://localhost:8080/api/employee/1 

### CLEAN UP PROCESS 
### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)