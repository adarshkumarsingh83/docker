# ORACLE DB SETUP FROM ORACLE DOCKER REGISTRY 

--- 

## Visit oracle docker registry 
* container-registry.oracle.com


## select for the database 
* select what type of database we want std enterprise or xe 
* for xe login is not required 


## login into the oracle docker registry 
```
$ docker login container-registry.oracle.com

UserName: xxxxx  // oracle account username 
Password: xxxx   // oracle account pwd  

Login Succeeded 

```

### To Download the docker db iamge 
* docker pull container-registry.oracle.com/database/express:latest


### To Run the Xe Docker image 

```
docker run --name <container name> \
-p <host port>:1521 -p <host port>:5500 \
-e ORACLE_PWD=<your database passwords> \
-e ORACLE_CHARACTERSET=<your character set> \
-v [<host mount point>:]/opt/oracle/oradata \
container-registry.oracle.com/database/express:21.3.0-xe
```

* docker run --name OracleXE \
-p 1521:1521 \
-p 5500:5500 \
-e ORACLE_PWD=12345 \
-e ORACLE_CHARACTERSET=AL32UTF8 \
-v oracle-data:/opt/oracle/oradata \
container-registry.oracle.com/database/express:latest

```
Starting Oracle Net Listener.
Oracle Net Listener started.
Starting Oracle Database instance XE.
Oracle Database instance XE started.

The Oracle base remains unchanged with value /opt/oracle

SQL*Plus: Release 21.0.0.0.0 - Production on Tue Aug 23 22:27:04 2022
Version 21.3.0.0.0

Copyright (c) 1982, 2021, Oracle.  All rights reserved.


Connected to:
Oracle Database 21c Express Edition Release 21.0.0.0.0 - Production
Version 21.3.0.0.0

SQL> 
User altered.

SQL> 
User altered.

SQL> 
Session altered.

SQL> 
User altered.

SQL> Disconnected from Oracle Database 21c Express Edition Release 21.0.0.0.0 - Production
Version 21.3.0.0.0
The Oracle base remains unchanged with value /opt/oracle
#########################
DATABASE IS READY TO USE!
#########################
The following output is now a tail of the alert.log:
XEPDB1(3):SUPLOG: Set PDB SUPLOG SGA at PDB OPEN, old 0x18, new 0x0 (no suplog)
XEPDB1(3):Opening pdb with Resource Manager plan: DEFAULT_PLAN
Pluggable database XEPDB1 opened read write
Starting background process CJQ0
2022-08-23T22:27:04.660736+00:00
CJQ0 started with pid=54, OS id=327 
Completed: ALTER DATABASE OPEN
2022-08-23T22:27:05.103077+00:00
TABLE AUDSYS.AUD$UNIFIED: ADDED INTERVAL PARTITION SYS_P328 (2976) VALUES LESS THAN (TIMESTAMP' 2022-08-24 00:00:00')
XEPDB1(3):TABLE AUDSYS.AUD$UNIFIED: ADDED INTERVAL PARTITION SYS_P348 (2976) VALUES LESS THAN (TIMESTAMP' 2022-08-24 00:00:00')
2022-08-23T22:27:06.100852+00:00
===========================================================
Dumping current patch information
===========================================================
No patches have been applied
===========================================================
2022-08-23T22:27:06.257089+00:00
XEPDB1(3):Resize operation completed for file# 10, fname /opt/oracle/oradata/XE/XEPDB1/sysaux01.dbf, old size 337920K, new size 358400K
```
