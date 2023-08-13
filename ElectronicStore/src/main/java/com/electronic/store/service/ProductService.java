package com.electronic.store.service;

import java.util.List;

import com.electronic.store.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	public List<Product> getAllProduct();
	public Product getProductById(long product_Id);
	public Product updateProduct(Product product );
	public void deleteProductById(long product_Id);
	
	
	

}
