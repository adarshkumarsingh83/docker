package com.espark.adarsh.configuration;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(
		basePackages = "com.espark.adarsh",
		namedQueriesLocation = "classpath:solr-named-queries.properties",
		multicoreSupport = true)
@ComponentScan
public class SolrConfig {

	@Value("${spring.data.solr.zk-host}")
	private String zkHost;

	@Bean
	public SolrClient solrClient() {
		return new CloudSolrClient(zkHost);
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient solrClient) {
		return new SolrTemplate(solrClient);
	}

}
