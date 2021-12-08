# MONGO DB DOCKER 

---

### Download mongo docker image from docker hub
* $ sudo docker pull mongo

### To start mongo
* $ docker run  -it -p 27017:27017 --name espark-mongo mongo:latest

### interact with the database through the bash shell client.
* $ docker exec -it espark-mongo bash

### create a new database
* $ mongo 
* $ use espark

### save and fetch operation via mongo shell 
```
$ db.employee.save({ name: "adarsh",email:"adarsh@kumar" })
$ db.employee.save({ name: "radha",email:"radha@singh" })
$ db.employee.find({ name: "adarsh" })
```
