# SPRING BOOT ELASTIC LOG STASH GRAFANA 
### DESCRIPTION 
> spring boot application has exposed api endpoints it used H2 in memo db
> internally  where it will store the employee information and spring boot 
> uses jpa to get the db data and expose to the external world 
>
> this application generated the logs which will be pushed to log stash by using 
> tcp log stash appender and then indexed into the elastic then grafana will 
> read those logs from the index then show into the dashboard for that we have to 
> create a data source into the grafana using elastic and provide the elastic 
> url, username and pwd and index name and then create a dashboard using that data source. 
> url http://elasticsearch:9200
> USERNAME=elastic
> PASSWORD=changeme
> espark     


## STEP TO FOLLOW
### TO BUILD THE CODE 
* $ mvn clean package

### EXECUTE THE DOCKER COMPOSE 
* $ docker-compose up

### SPRING BOOT API END POINTS
* $ curl http://localhost:8080/api/employees

### ELASTIC URLS
````
* http://localhost:9200/_all
* https://localhost:9200/espark/_search?pretty
* http://localhost:9200/_aliases?pretty=true
* http://localhost:9200/_cat/indices?v
* http://localhost:9200/_cluster/health?level=indices
````

## TO LOG INTO THE GRAFANA
* http://localhost:3000/login
- admin/password

````
 Create a data source select the elastic and then provide the data
  URL= http://elasticsearch:9200
  USERNAME= elastic
  PASSWORD= elastic
  INDEX= espark

````

### TO BRING DOWN DOCKER COMPOSE 
* $ docker-compose down

### TO DELETE ALL THE CONTAINERS WITH VOLUMES
* $ docker rm -vf $(docker ps -a -q)

### TO DELETE ALL THE IMAGES
* $ docker rmi -f $(docker images -a -q)