
# MYSQL DB DOCKER

### Download mongo docker image from docker hub
* $ sudo docker pull mysql

### To start mongo
* $ docker run --name <mysql-instance-name> -e MYSQL_ROOT_PASSWORD=<root-user-ped> -e MYSQL_DATABASE=<mysql-db-name> -d mysql:<5.6]>
* $ docker run -p 3306:3306 --name espark-mysql -e MYSQL_ROOT_PASSWORD=rootPwd -e MYSQL_DATABASE=espark  mysql:5.6

### interact with the database through the bash shell client.
* $ docker exec -it espark-mysql bash


### To Download mysql Workbench 
* https://www.mysql.com/products/workbench/