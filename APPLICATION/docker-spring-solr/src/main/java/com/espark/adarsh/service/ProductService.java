package com.espark.adarsh.service;

import com.espark.adarsh.entity.Product;
import com.espark.adarsh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product create(final Product product) {
		return productRepository.save(product);
	}

}
