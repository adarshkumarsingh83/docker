# docker-spring-solr

## How to

### Run all :smiley:

```bash
docker-compose up
```

- Run just one single Solr: `docker run --name my_solr --rm -p 8983:8983 solr:7.1`
- Access http://localhost:8983

### Solr

- Create a `product` collection executing a `solr command` (a new config called `myconfig` will be created)

```bash
docker exec -it --user=solr my_solr solr create -c product -n myconfig
```

- Create a `product` collection calling a `REST Api`

First, create a config

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     'http://localhost:8983/solr/admin/configs?action=CREATE&name=myconfig&baseConfigSet=_default'
```

And then, create a collection

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     'http://localhost:8983/solr/admin/collections?action=CREATE&name=product&numShards=2&replicationFactor=2&maxShardsPerNode=2&collection.configName=myconfig'
```

#### Manipulate products directly from Solr

```bash
curl http://localhost:8983/solr/product/update?commit=true -d "[ {\"id\" : \"1\",  \"name\" : \"Smartphone\" }]"
```

Show directly from Solr

- Show by id
```bash
curl 'http://localhost:8983/solr/product/get?id=1'
```

- Show all
```bash
curl 'http://localhost:8983/solr/product/select?q=*:*'
```

### Spring Boot Application with Spring Data Solr

Create product in application

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     -d '{"id":"2", "name":"iMac"}' \
     http://localhost:8080/products
```

## Examples of index

Execute an interactive bash shell on the container

```bash
docker exec -it my_solr bash
```

Load data

```bash
bin/solr create -c gettingstarted
bin/post -c gettingstarted example/exampledocs/*.xml
```
