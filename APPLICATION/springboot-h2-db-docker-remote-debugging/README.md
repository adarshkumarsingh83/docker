# springboot-h2-db-docker-remote-debugging

---

### to build the application
* $ mvn clean package

### To Run the application 
* $ mvn spring-boot:run

### log into the homepage of db
* http://localhost:8080/h2-console
```
username, pwd , dburl and db driver class is mentioned in application.properties file
```

### To Test the api 
* curl -X GET http://localhost:8080/employees
````
[
  {
    "id": 1,
    "firstName": "adarsh",
    "lastName": "kumar",
    "career": "It"
  },
  {
    "id": 2,
    "firstName": "radha",
    "lastName": "singh",
    "career": "IT"
  },
  {
    "id": 3,
    "firstName": "sonu",
    "lastName": "singh",
    "career": "IT"
  },
  {
    "id": 4,
    "firstName": "amit",
    "lastName": "kumar",
    "career": "Finance"
  }
]
````
## To Create docker image 
* docker build -t springboot-h2-db-docker-remote-debugging .
````
 [+] Building 17.0s (9/9) FINISHED                                                                                                                                                                 
 => [internal] load build definition from Dockerfile                                                                                                                                         0.0s
 => => transferring dockerfile: 261B                                                                                                                                                         0.0s
 => [internal] load .dockerignore                                                                                                                                                            0.0s
 => => transferring context: 2B                                                                                                                                                              0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                 1.3s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                               0.0s
 => [internal] load build context                                                                                                                                                            1.0s
 => => transferring context: 38.72MB                                                                                                                                                         1.0s
 => [1/3] FROM docker.io/library/openjdk:8@sha256:208812d8c45e0f5cb51c35b143094bd28322bad83ec8e463a1cbe3c5a6308b1f                                                                          15.1s
 => => resolve docker.io/library/openjdk:8@sha256:208812d8c45e0f5cb51c35b143094bd28322bad83ec8e463a1cbe3c5a6308b1f                                                                           0.0s
 => => sha256:47482c603b2a221f7f968380801639c3d108d18d33d77c93d44cfe8953c90548 7.81kB / 7.81kB                                                                                               0.0s
 => => sha256:e6d3e61f7a504fa66d7275123969e9917570188650eb84b2280a726b996040f6 10.87MB / 10.87MB                                                                                             1.3s
 => => sha256:208812d8c45e0f5cb51c35b143094bd28322bad83ec8e463a1cbe3c5a6308b1f 1.04kB / 1.04kB                                                                                               0.0s
 => => sha256:93227b5ffb978363dfa3d493a0d25ccc943405260865437660bfec2af3174a73 1.79kB / 1.79kB                                                                                               0.0s
 => => sha256:0c6b8ff8c37e92eb1ca65ed8917e818927d5bf318b6f18896049b5d9afc28343 54.92MB / 54.92MB                                                                                             5.0s
 => => sha256:412caad352a3ecbb29c080379407ae0761e7b9b454f7239cbfd1d1da25e06b29 5.15MB / 5.15MB                                                                                               1.0s
 => => sha256:461bb1d8c517c7f9fc0f1df66c9dc34c85a23421c1e1c540b2e28cbb258e75f5 54.57MB / 54.57MB                                                                                             4.5s
 => => sha256:e442ee9d8dd9896a5b3b67117060f2af4ae8e997af7297009e7d0ea4b6595163 5.42MB / 5.42MB                                                                                               2.0s
 => => sha256:36b5bcea956cbbcc7e16356354d5eb4b5b3834a43d708ca6c3fd048f33ddc579 211B / 211B                                                                                                   2.1s
 => => sha256:8ed70148ebcf78cba8546f5af3e152a6d9422a3a9d814d7683242e4663e773c3 106.07MB / 106.07MB                                                                                           7.3s
 => => extracting sha256:0c6b8ff8c37e92eb1ca65ed8917e818927d5bf318b6f18896049b5d9afc28343                                                                                                    2.6s
 => => extracting sha256:412caad352a3ecbb29c080379407ae0761e7b9b454f7239cbfd1d1da25e06b29                                                                                                    0.2s
 => => extracting sha256:e6d3e61f7a504fa66d7275123969e9917570188650eb84b2280a726b996040f6                                                                                                    0.3s
 => => extracting sha256:461bb1d8c517c7f9fc0f1df66c9dc34c85a23421c1e1c540b2e28cbb258e75f5                                                                                                    2.8s
 => => extracting sha256:e442ee9d8dd9896a5b3b67117060f2af4ae8e997af7297009e7d0ea4b6595163                                                                                                    0.2s
 => => extracting sha256:36b5bcea956cbbcc7e16356354d5eb4b5b3834a43d708ca6c3fd048f33ddc579                                                                                                    0.0s
 => => extracting sha256:8ed70148ebcf78cba8546f5af3e152a6d9422a3a9d814d7683242e4663e773c3                                                                                                    3.1s
 => [2/3] ADD target/springboot-h2-db-docker-remote-debugging.jar springboot-h2-db-docker-remote-debugging.jar                                                                               0.3s
 => [3/3] ADD docker-debugging.sh docker-debugging.sh                                                                                                                                        0.0s
 => exporting to image                                                                                                                                                                       0.2s
 => => exporting layers                                                                                                                                                                      0.2s
 => => writing image sha256:ab8c7e3c84ac9f76cd81241c8a96dab6b987d17f80ab8e494e11c535bab3b9f2                                                                                                 0.0s
 => => naming to docker.io/library/springboot-h2-db-docker-remote-debugging                                                                                                                  0.0s

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them
````
### To list the image 
* docker images 
```   
REPOSITORY                                 TAG            IMAGE ID       CREATED          SIZE
springboot-h2-db-docker-remote-debugging   latest         ab8c7e3c84ac   29 seconds ago   565MB
```

### To run the image 
* docker run -p 8080:8080 -p 8090:8090  springboot-h2-db-docker-remote-debugging
```
Listening for transport dt_socket at address: 8090

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2022-02-25 17:35:04.101  INFO 7 --- [           main] com.espark.adarsh.ApplicationMain        : Starting ApplicationMain v0.0.1-SNAPSHOT on 725413a488b6 with PID 7 (/springboot-h2-db-docker-remote-debugging.jar started by root in /)
2022-02-25 17:35:04.105  INFO 7 --- [           main] com.espark.adarsh.ApplicationMain        : No active profile set, falling back to default profiles: default
2022-02-25 17:35:04.890  INFO 7 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-02-25 17:35:04.968  INFO 7 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 65ms. Found 1 JPA repository interfaces.
2022-02-25 17:35:05.774  INFO 7 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-02-25 17:35:05.790  INFO 7 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-02-25 17:35:05.790  INFO 7 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.33]
2022-02-25 17:35:05.861  INFO 7 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-02-25 17:35:05.862  INFO 7 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1694 ms
2022-02-25 17:35:05.918  INFO 7 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-02-25 17:35:06.244  INFO 7 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-02-25 17:35:06.252  INFO 7 --- [           main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
2022-02-25 17:35:06.416  INFO 7 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-02-25 17:35:06.502  INFO 7 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.12.Final
2022-02-25 17:35:06.751  INFO 7 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2022-02-25 17:35:06.974  INFO 7 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2022-02-25 17:35:07.970  INFO 7 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-02-25 17:35:07.979  INFO 7 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-02-25 17:35:08.371  WARN 7 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-02-25 17:35:08.538  INFO 7 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-02-25 17:35:08.855  INFO 7 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-02-25 17:35:08.857  INFO 7 --- [           main] com.espark.adarsh.ApplicationMain        : Started ApplicationMain in 5.244 seconds (JVM running for 5.865)  
```

### To Add Remote Debugging in Intellj ide 
* Go to Edit Configuration of Run 
    * Click on + button in left corner 
      * Search for the Remote JVM Debugging 
        * provide the name = xxx 
        * Debugger mode = attach to remote jvm 
        * host = host name
        * port =  which we have given for remote debugging and save it 
* start the application in debugging 
* add the debugging point in the code and hit the api for debugging 