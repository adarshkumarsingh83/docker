# SPRING BOOT ELASTIC LOG STASH KIBINA 
### DESCRIPTION 
> spring boot application has exposed api endpoints it used H2 in memo db
> internally  where it will store the employee information and spring boot 
> uses jpa to get the db data and expose to the external world 
>
> this application generated the logs which will be pushed to log stash by using 
> tcp log stash appender and then indexed into the elastic then kibina will 
> read those logs from the index then show into the dashboard for that we have to 


## STEP TO FOLLOW
### TO BUILD THE CODE 
* $ mvn clean package

### EXECUTE THE DOCKER COMPOSE 
* $ docker-compose up

### SPRING BOOT API END POINTS
* $ curl http://localhost:8080/api/employees

### ELASTIC URLS
````
* http://localhost:9200/_aliases?pretty=true
* http://localhost:9200/_cat/indices?v
* http://localhost:9200/_cluster/health?level=indices
````

### LOG INTO THE KIBINA DASHBOARD 
* http://localhost:5601
````
got to management -> index pattern -> create index pattern
with  => espark* =>  then configuration setting  => @timestap -> created

go to the Discover -> log browser
views the logs their  
````

### TO BRING DOWN DOCKER COMPOSE 
* $ docker-compose down

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)

