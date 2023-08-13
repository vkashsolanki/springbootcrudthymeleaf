package com.electronic.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.store.exception.ProductNotFoundException;
import com.electronic.store.model.Product;
import com.electronic.store.repo.ProductRepository;

@Service
public class ProdcutServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;

	@Override
	public Product saveProduct(Product product) {
		Product save = repository.save(product);
		return save;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = repository.findAll();
		return list;
	}

	@Override
	public Product getProductById(long product_Id) {
		Optional<Product> opt = repository.findById(product_Id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ProductNotFoundException("Product with Id "+product_Id+ "Not Found ");
		}
		
	}

	@Override
	public Product updateProduct(Product product) {
		Product save = repository.save(product);
		return save;
	}

	@Override
	public void deleteProductById(long product_Id) {
		
		repository.delete(getProductById(product_Id));
				
	}
	


	
	
	
	
	

}
