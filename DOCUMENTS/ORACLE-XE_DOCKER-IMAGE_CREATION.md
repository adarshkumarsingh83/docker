
## Clone the git hub from oracle 
*  git clone git@github.com:oracle/docker-images.git 

## move to the docker file directory 
* $ cd docker-images/OracleDatabase/SingleInstance/dockerfiles

# list the supported version 
* $ ls 
```
11.2.0.2		12.2.0.1		18.4.0			21.3.0
12.1.0.2		18.3.0			19.3.0			buildContainerImage.sh
```

## url to download the verion of oracle zip 
* https://www.oracle.com/database/technologies/xe18c-downloads.html
* copy into the same directtoy of the version in ls cmd 

## Build the docker iamge 
* $  sh buildContainerImage.sh -v 18.4.0 -x

``` 
Oracle Database container image for 'xe' version 18.4.0 is ready to be extended: 
    
    --> oracle/database:18.4.0-xe

  Build completed in 510 seconds.
```

## To list the docker iamges 
* $ docker images ls 

## db client opernsource 
* https://dbeaver.io/download/

## oracle sql developer client 
* https://www.oracle.com/tools/downloads/sqldev-downloads.html

##  launch the db 
* $ docker run --name OracleXE \
--shm-size=1g \
-p 1521:1521 \
-p 8081:8080 \
-e ORACLE_PWD=12345 \
-v oracle-data:/u01/app/oracle/oradata \
oracle/database:18.4.0-xe

``` 
ORACLE PASSWORD FOR SYS AND SYSTEM: 12345
Specify a password to be used for database accounts. Oracle recommends that the password entered should be at least 8 characters in length, contain at least 1 uppercase character, 1 lower case character and 1 digit [0-9]. Note that the same password will be used for SYS, SYSTEM and PDBADMIN accounts:
Confirm the password:
Configuring Oracle Listener.
Listener configuration succeeded.
Configuring Oracle Database XE.
Enter SYS user password: 
******
Enter SYSTEM user password: 
*****
Enter PDBADMIN User Password: 
*****
Prepare for db operation
7% complete
Copying database files
29% complete
Creating and starting Oracle instance
Completing Database Creation
47% complete
50% complete
Creating Pluggable Databases
54% complete
71% complete
Executing Post Configuration Actions
93% complete
Running Custom Scripts
100% complete
Database creation complete. For details check the logfiles at:
 /opt/oracle/cfgtoollogs/dbca/XE.
Database Information:
Global Database Name:XE
System Identifier(SID):XE
Look at the log file "/opt/oracle/cfgtoollogs/dbca/XE/XE.log" for further details.

Connect to Oracle Database using one of the connect strings:
     Pluggable database: 2f7354fc4ee1/XEPDB1
     Multitenant container database: 2f7354fc4ee1
Use https://localhost:5500/em to access Oracle Enterprise Manager for Oracle Database XE
The Oracle base remains unchanged with value /opt/oracle
#########################
DATABASE IS READY TO USE!
#########################
The following output is now a tail of the alert.log:
2021-10-05T23:03:43.054971+00:00
XEPDB1(3):Resize operation completed for file# 10, old size 358400K, new size 368640K
2021-10-05T23:03:56.975470+00:00
XEPDB1(3):CREATE SMALLFILE TABLESPACE "USERS" LOGGING  DATAFILE  '/opt/oracle/oradata/XE/XEPDB1/users01.dbf' SIZE 5M REUSE AUTOEXTEND ON NEXT  1280K MAXSIZE UNLIMITED  EXTENT MANAGEMENT LOCAL  SEGMENT SPACE MANAGEMENT  AUTO
XEPDB1(3):Completed: CREATE SMALLFILE TABLESPACE "USERS" LOGGING  DATAFILE  '/opt/oracle/oradata/XE/XEPDB1/users01.dbf' SIZE 5M REUSE AUTOEXTEND ON NEXT  1280K MAXSIZE UNLIMITED  EXTENT MANAGEMENT LOCAL  SEGMENT SPACE MANAGEMENT  AUTO
XEPDB1(3):ALTER DATABASE DEFAULT TABLESPACE "USERS"
XEPDB1(3):Completed: ALTER DATABASE DEFAULT TABLESPACE "USERS"
2021-10-05T23:04:03.318085+00:00
ALTER PLUGGABLE DATABASE XEPDB1 SAVE STATE
Completed: ALTER PLUGGABLE DATABASE XEPDB1 SAVE STATE

```

## Connect to db
```
Host: localhost
Port: 1521
Database: XE
Use SID
User name: SYS
Role: SYSDBA
Password: 12345
```

## Clean up 
* docker ps -a
* docker rm [OPTIONS] CONTAINER [CONTAINER...]
* docker rm -f [CONTAINER_ID] 
* docker rm -f 2f7354fc4ee1 
* docker rm -f [CONTAINER_NAME] OracleXE
* docker rm -f  OracleXE


## docker login 
* $ docker login 
```
Login with your Docker ID to push and pull images from Docker Hub. If you don't have a Docker ID, head over to https://hub.docker.com to create one.
Username: adarshkumarsingh83
Password: *********
Login Succeeded

Logging in with your password grants your terminal complete access to your account. 
For better security, log in with a limited-privilege personal access token. Learn more at https://docs.docker.com/go/access-tokens/
```


## To tag the docker iamge for repo 
* $ docker tag oracle/database:18.4.0-xe adarshkumarsingh83/oracle:18.4.0-xe
```
REPOSITORY                                            TAG            IMAGE ID       CREATED        SIZE
adarshkumarsingh83/oracle                             18.4.0-xe      c265dc4e3bd6   3 months ago   5.89GB
oracle/database                                       18.4.0-xe      c265dc4e3bd6   3 months ago   5.89GB
```
### To push docker image to the doker hub 
* $ docker push adarshkumarsingh83/oracle:18.4.0-xe
```
The push refers to repository [docker.io/adarshkumarsingh83/oracle]
8b87b2186514: Pushed 
2c34696ea563: Pushed 
55bee6be610f: Mounted from library/oraclelinux 
18.4.0-xe: digest: sha256:d7544b7b89029dbdb88e46285197f6305a5cf7e1cd6234715ee9fa38ad4af7bb size: 951
```

## docker logout 
* $ docker logout 
```
Removing login credentials for https://index.docker.io/v1/
```
