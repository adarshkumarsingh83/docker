# oracle-liquibase-example1

---

### location in project directory

- $ pwd

```
/Volume/oracle-liquibase-initcontainer
```

### project directory structure

```
$ tree -f
.
├── ./README.md
├── ./lib
│   └── ./lib/ojdbc11-21.3.0.0.jar
└── ./resources
    ├── ./resources/changelog
    │   ├── ./resources/changelog/changelog.xml
    │   └── ./resources/changelog/changes
    │       └── ./resources/changelog/changes/sql
    │           ├── ./resources/changelog/changes/sql/create_schema.sql
    │           ├── ./resources/changelog/changes/sql/insert_data.sql
    │           └── ./resources/changelog/changes/sql/select_data.sql
    └── ./resources/liquibase.properties
```

### to create a new network

- $ docker network create espark-net

### To list the network

- $ docker network list

### To start the oracle database

```
 docker run --name OracleXE \
  --shm-size=1g \
  --hostname OracleXE \
  --net espark-net \
  -p 1521:1521 \
  -p 8081:8080 \
  -e ORACLE_PWD=12345 \
  -v oracle-data:/u01/app/oracle/oradata \
  oracle/database:18.4.0-xe
```

## get inside the oracle container and find this host and port

- lsnrctl status

## TO TRUNCATE THE DB TABLES

- truncate table system.DATABASECHANGELOG;
- truncate table system.DATABASECHANGELOGLOCK;

### To start the liquidbase cmd

```
 docker run --rm \
--name espark-liquibase \
--net espark-net \
 -v $(pwd)/resources:/liquibase/changelog \
 -v $(pwd)/resources/changelog/changes:/liquibase/changelog/changelog/changes \
 -v $(pwd)/resources/changelog/changes/sql:/liquibase/changelog/changelog/changes/sql \
 -v $(pwd)/lib:/liquibase/classpath/ojdbc11-21.3.0.0.jar liquibase/liquibase:latest \
 --defaultsFile=/liquibase/changelog/liquibase.properties \
 --classpath=/liquibase/changelog:/liquibase/classpath/ojdbc11-21.3.0.0.jar \
 --changeLogFile=changelog/changelog.xml update
```

### Actual execution

```
$  docker run --rm \
> --name espark-liquibase \
> --net espark-net \
>  -v $(pwd)/resources:/liquibase/changelog \
>  -v $(pwd)/resources/changelog/changes/sql:/liquibase/changelog/changelog/changes/sql \
>  -v $(pwd)/resources/changelog/changes:/liquibase/changelog/changelog/changes \
>  -v $(pwd)/lib:/liquibase/classpath/ojdbc11-21.3.0.0.jar liquibase/liquibase:latest \
>  --defaultsFile=/liquibase/changelog/liquibase.properties \
>  --classpath=/liquibase/changelog:/liquibase/classpath/ojdbc11-21.3.0.0.jar \
>  --changeLogFile=changelog/changelog.xml update
####################################################
##   _     _             _ _                      ##
##  | |   (_)           (_) |                     ##
##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
##              | |                               ##
##              |_|                               ##
##                                                ##
##  Get documentation at docs.liquibase.com       ##
##  Get certified courses at learn.liquibase.com  ##
##  Free schema change activity reports at        ##
##      https://hub.liquibase.com                 ##
##                                                ##
####################################################
Starting Liquibase at 20:49:00 (version 4.8.0 #1581 built at 2022-02-18 21:43+0000)
Liquibase Version: 4.8.0
Liquibase Community 4.8.0 by Liquibase
Liquibase command 'update' was executed successfully.
```

### connect the oralce db from sql developer

- system->tables -> employees
