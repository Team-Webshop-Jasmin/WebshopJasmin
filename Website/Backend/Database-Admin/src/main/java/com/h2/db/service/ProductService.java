package com.h2.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.h2.db.exception.RecordNotFoundException;
import com.h2.db.model.ProductEntity;
import com.h2.db.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public List<ProductEntity> getAllProducts()
	{
		System.out.println("getAllProducts");
		List<ProductEntity> result = (List<ProductEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<ProductEntity>();
		}
	}

	
	public ProductEntity getProductById(Long id) throws RecordNotFoundException
	{
		System.out.println("getProductById");
		Optional<ProductEntity> product = repository.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		} else {
			throw new RecordNotFoundException("No product record exist for given id");
		}
	}
	
	public ProductEntity createOrUpdateProduct(ProductEntity entity)
	{
		System.out.println("createOrUpdateProduct");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<ProductEntity> product = repository.findById(entity.getId());
			
			if(product.isPresent())
			{
				ProductEntity newEntity = product.get();
				newEntity.setName(entity.getName());
				newEntity.setPrice(entity.getPrice());
				newEntity.setWeight(entity.getWeight());
				newEntity.setDescription(entity.getDescription());
				newEntity.setStock(entity.getStock());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteProductById(Long id) throws RecordNotFoundException
	{
		System.out.println("deleteProductById");
		
		Optional<ProductEntity> product = repository.findById(id);
		
		if(product.isPresent())
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No product record exist for given id");
		}
	} 
}