package com.espark.adarsh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {


    @Value("${spring.data.cassandra.keyspace-name}")
    String keyspaceName;

    @Value("${spring.data.cassandra.port}")
    int port;

    @Value("${spring.data.cassandra.contact-points}")
    String contactPoints;

    @Value("${spring.data.cassandra.entity-base-package}")
    String baseEntityPackage;

    @Value("${spring.data.cassandra.local-datacenter}")
    String dataCenter;

    @Value("${spring.data.cassandra.username}")
    String username;


    @Value("${spring.data.cassandra.password}")
    String password;


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
    public List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification
                .createKeyspace(keyspaceName)
                .ifNotExists());
    }


    @Override
    @Bean
    @Profile({"docker", "kubernates"})
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean session = super.cassandraSession();
        session.setPassword(password);
        session.setUsername(username);
        return session;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{baseEntityPackage};
    }

    @Override
    public String getLocalDataCenter() {
        return dataCenter;
    }
}
