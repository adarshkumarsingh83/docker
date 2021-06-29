package com.espark.adarsh.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

@SolrDocument(solrCoreName = "repository")
public class Product implements Serializable{

	@Id
	@Indexed(name = "id", type = "string")
	private String id;

	@Indexed(name = "name", type = "string")
	private String name;

	public Product() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
