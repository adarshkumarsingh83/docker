
# spring boot splunk

### to build the application
* $ mvn clean package

### To Run the application 
* $ mvn spring-boot:run

### log into the homepage of db
* http://localhost:8080/h2-console
```
username, pwd , dburl and db driver class is mentioned in application.properties file
```

### To Build the docker tag 
* $ docker build -f Dockerfile -t adarshkumarsingh83/springboot-splunk .
```         
[+] Building 2.2s (8/8) FINISHED                                                                                                                                                                      
 => [internal] load build definition from Dockerfile                                                                                                                                             0.0s
 => => transferring dockerfile: 37B                                                                                                                                                              0.0s
 => [internal] load .dockerignore                                                                                                                                                                0.0s
 => => transferring context: 2B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                     1.3s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                                   0.0s
 => [internal] load build context                                                                                                                                                                0.4s
 => => transferring context: 48.72MB                                                                                                                                                             0.4s
 => CACHED [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                        0.0s
 => [2/2] COPY target/springboot-splunk.jar springboot-splunk.jar                                                                                                                                0.1s
 => exporting to image                                                                                                                                                                           0.2s
 => => exporting layers                                                                                                                                                                          0.2s
 => => writing image sha256:6ef0d66ca9bd6fbb780120063ff99bdcce99a727afee5a852e0f8ed3af628b7c                                                                                                     0.0s
 => => naming to docker.io/adarshkumarsingh83/springboot-splunk     
```
### To push to the docker hub 
* $ docker push adarshkumarsingh83/springboot-splunk

### To Run 
* docker-compose up 
## To stop 
* docker-compose down 

### To Test the Api
* curl -X GET http://localhost:8080/employees

### To login into splunk 
* http://localhost:8000
  * admin/Tiger@007

### Search keyword 
* host=splunkforwarder

## To find the log forwarder to splunk
* Search & Reporting -> Data Summary -> Host -> splunkforwarder