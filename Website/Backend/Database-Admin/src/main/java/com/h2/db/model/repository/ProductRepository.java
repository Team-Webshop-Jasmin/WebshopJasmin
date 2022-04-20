package com.h2.db.model.repository;

import com.h2.db.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository
			extends CrudRepository<ProductEntity, Long> {

}
