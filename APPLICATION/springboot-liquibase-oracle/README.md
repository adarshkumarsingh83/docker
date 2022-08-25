# Springboot-liquibase-standalone
---

### [step by step guide for oracle xe db docker image ](ORACLE-DB-DOCKER-ORACLE-REPOSITORY-README.md)

### TO BUILD THE CODE 
* mvn clean install -DskipTests
* or 
* mvn clean install -Dmaven.test.skip=true


## To Execute the 
* mvn spring-boot:run 

## To Build Docker image 
* $ docker build -f Dockerfile -t springboot-liquibase-oracle .

## To List Image 
* $ docker images

## Docker n/w creation 
* docker network create mynet

##  launch the db
* $ docker run --name OracleXE \
  --shm-size=1g \
  --network=mynet \
  -p 1521:1521 \
  -p 8081:8080 \
  -e ORACLE_PWD=12345 \
  -h OracleXE \
  -v oracle-data:/u01/app/oracle/oradata \
  oracle/database:18.4.0-xe

## To Execute Image
* docker run -e "SPRING_PROFILES_ACTIVE=docker" --network=mynet  springboot-liquibase-oracle --name springboot-liquibase-oracle

```        
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.2)

2022-08-18 20:30:45.100  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : Starting SpringbootLiquibaseApplication v0.0.1-SNAPSHOT using Java 11.0.16 on f380f03a3751 with PID 1 (/springboot-liquibase.jar started by root in /)
2022-08-18 20:30:45.105  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : The following 1 profile is active: "docker"
2022-08-18 20:30:46.461  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Starting...
2022-08-18 20:30:46.895  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Start completed.
2022-08-18 20:30:46.941  INFO 1 --- [           main] liquibase.database                       : Could not set remarks reporting on OracleDatabase: com.zaxxer.hikari.pool.HikariProxyConnection.setRemarksReporting(boolean)
2022-08-18 20:30:47.627  INFO 1 --- [           main] liquibase.lockservice                    : Successfully acquired change log lock
2022-08-18 20:30:47.641  INFO 1 --- [           main] liquibase.command                        : Dropping Database Objects in schema: SYSTEM.SYSTEM
2022-08-18 20:30:47.676  INFO 1 --- [           main] liquibase.changelog                      : Creating database history table with name: SYSTEM.DATABASECHANGELOG
2022-08-18 20:30:52.644  INFO 1 --- [           main] liquibase.database                       : Successfully deleted all supported object types in schema SYSTEM.SYSTEM.
2022-08-18 20:30:52.647  INFO 1 --- [           main] liquibase.lockservice                    : Successfully released change log lock
All objects dropped from SYSTEM@jdbc:oracle:thin:@//OracleXE:1521/XE
2022-08-18 20:30:52.727  INFO 1 --- [           main] liquibase.lockservice                    : Successfully acquired change log lock
2022-08-18 20:30:53.141  INFO 1 --- [           main] liquibase.changelog                      : Creating database history table with name: SYSTEM.DATABASECHANGELOG
2022-08-18 20:30:53.166  INFO 1 --- [           main] liquibase.changelog                      : Reading from SYSTEM.DATABASECHANGELOG
Running Changeset: db/changelog/db.changelog-master.xml::1::adarsh
2022-08-18 20:30:53.264  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/create_schema.sql executed
2022-08-18 20:30:53.265  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::1::adarsh ran successfully in 35ms
Running Changeset: db/changelog/db.changelog-master.xml::2::radha
2022-08-18 20:30:53.290  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/insert_data.sql executed
2022-08-18 20:30:53.294  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::2::radha ran successfully in 19ms
Running Changeset: db/changelog/db.changelog-master.xml::3::radha
2022-08-18 20:30:53.446  INFO 1 --- [           main] liquibase.changelog                      : SQL in file db/changelog/changes/sql/select_data.sql executed
2022-08-18 20:30:53.447  INFO 1 --- [           main] liquibase.changelog                      : ChangeSet db/changelog/db.changelog-master.xml::3::radha ran successfully in 146ms
2022-08-18 20:30:53.458  INFO 1 --- [           main] liquibase.lockservice                    : Successfully released change log lock
2022-08-18 20:30:53.551  INFO 1 --- [           main] c.e.a.SpringbootLiquibaseApplication     : Started SpringbootLiquibaseApplication in 9.161 seconds (JVM running for 9.717)
2022-08-18 20:30:53.561  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Shutdown initiated...
2022-08-18 20:30:53.586  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : hikar-pool - Shutdown completed.
```


## DROP THE TABLE 
``` 
drop table system.EMPLOYEE;
drop table system.DATABASECHANGELOG;
drop table system.DATABASECHANGELOGLOCK;
```