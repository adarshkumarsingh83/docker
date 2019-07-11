package com.espark.adarsh.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.espark.adarsh.repository")
public class EsConfiguration {


  /*  @Bean
    public Client client() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("cluster.name", "docker-cluster").build();
        @SuppressWarnings("resource")
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(
                                                   new InetSocketAddress(
                                                                 InetAddress.getByName("127.0.0.1"),9200)));
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticSearchOperations() throws UnknownHostException {
        return new ElasticsearchTemplate(this.client());
    }*/

}
