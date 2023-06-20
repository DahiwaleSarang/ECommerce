package com.ecommerce.cart.entity;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.cart.dto.CartProducts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "cart")
public class Cart {
	
	@Id
	private String cart_id;
	
	private Long userId;
	
	private List<CartProducts> cartProducts;

	@Override
	public int hashCode() {
		return Objects.hash(cartProducts, cart_id, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(cartProducts, other.cartProducts) && Objects.equals(cart_id, other.cart_id)
				&& Objects.equals(userId, other.userId);
	}

	

	
	

}
