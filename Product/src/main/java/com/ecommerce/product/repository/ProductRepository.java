package com.ecommerce.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
