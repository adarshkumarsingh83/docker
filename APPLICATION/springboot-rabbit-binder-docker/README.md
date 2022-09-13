# springboot rabbit binder producer processor consumer 

--- 
> producer will publish data to the rabbitmq \
> processor will take data transfom data and put back on rabbitmq \
> consumer will subscribe the data which is transformed 


### To Build
* mvn clean package -DskipTests

### To run 
* docker-compose up

### To shut down 
* docker-compose down


### Rabbitmq mgmt console 
* http://localhost:15672/
	* guest/guest 