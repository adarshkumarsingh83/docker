package com.espark.adarsh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCassandraRepositories
@ConfigurationProperties("spring.data.cassandra")
@PropertySource(value = {"classpath:application.yaml"})
public class CassandraConfig extends AbstractCassandraConfiguration {


    @Value("${keyspace-name}")
    String keyspaceName;

    @Value("${port}")
    int port;

    @Value("${contact-points}")
    String contactPoints;


    @Value("${entity-base-package}")
    String baseEntityPackage;

    @Value("${local-datacenter}")
    String dataCenter;


    @Override
    protected String getKeyspaceName() {
        return this.keyspaceName;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification
                .createKeyspace(keyspaceName)
                .ifNotExists());
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{baseEntityPackage};
    }

    @Override
    protected String getLocalDataCenter() {
        return dataCenter;
    }

}
