package com.ecommerce.cart.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.cart.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

	Optional<Cart> findByUserId(Long userId);
}
