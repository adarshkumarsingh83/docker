
### DOCKER PLUGIN PROCESS FOR SPRING BOOT OR JAVA 
> DESCRPTION: \
> process step by step for creating docker image form springboot/java \
> based on the maven plugin 
----

### To Check docker is working properly in maching 
* $ docker info
* $ docker-compose --version   

### Create a project and add the below plugin in the pom file 

````
 
   <plugin>
      <groupId>com.spotify</groupId>
      <artifactId>docker-maven-plugin</artifactId>
      <configuration>
        <imageName>${project.name}</imageName>
        <baseImage>java:8</baseImage>
        <entryPoint>["java", "-jar", "/${project.build.finalName}.jar"]</entryPoint>
        <resources>
           <resource>
             <targetPath>/</targetPath>
             <directory>${project.build.directory}</directory>
             <include>${project.build.finalName}.jar</include>
           </resource>
        </resources>
      </configuration>
    </plugin>
    
 OR   
 
  <plugins>   
    <finalName>${project.name}</finalName>   
     .............
  </plugins>    
  
````
  
### Create a docker file with Name 'Dockerfile' in the root dir of the project 
  
````   
 FROM opendjk:8
 ADD target/application-name.jar application-name.jar 
 EXPOSSE <PORT>
 ENTRYPOINT ["java","-jar","application-name.jar"]
````  
 
### TO CHECK THE DOCKER VERSION  
 * $ docker -v 

### TO BUILD THE DOCKER IAMGE FROM THE GENERATED JAR FILE 
 * $ docker build -f Dockerfile -t <tag-name> . 

### TO LIST THE DOCKER IMAGES
* $ docker image 
 
### TO EXECUTE THE DOCKER IAMGE 
* $ docker run -p <docker-container-port:machine-port> <docker-image-name>
 
----

### FOR DOCKER COMPOSE 

### Create a docker file with Name 'Dockerfile' in the root dir of the project 
````
FROM openjdk:8
MAINTAINER adarshkumarsingh83@gmail.com
ADD target/application-name.jar application-name.jar 
EXPOSE  <PORT>
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=xxx","application-name.jar"]
````
### Then create a file with Name 'docker-compose.yml' in the root project dir 

````
version: "3"
services:
  springboot-docker-compose-app-container1:
    image: springboot-docker-compose-app:1
    build:
      context: ./springboot-docker-compose-app1
      dockerfile: Dockerfile
    volumes:
      - /data/springboot-docker-compose-app1
    ports:
      - "8081:8081"
    networks:
      - spring-ms 
  springboot-docker-compose-app-container2:
    image: springboot-docker-compose-app:2
    build:
      context: ./springboot-docker-compose-app2
      dockerfile: Dockerfile
    volumes:
      - /data/springboot-docker-compose-app2
    ports:
      - "8081:8081"
    depends_on:
      - producer     
    networks:
      - spring-ms 
networks:
  spring-ms:
   
 ````
### For executing the docker compose use below cmd      
* $ docker-compose up       
* $ docker-compose down 

    