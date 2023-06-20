package com.ecommerce.cart.dto;

import java.time.Instant;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartProducts {

	private String productId;
	
	private Integer quantity;
	
	private Instant created_at;

	private Instant updated_at;

	@Override
	public int hashCode() {
		return Objects.hash(created_at, productId, quantity, updated_at);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProducts other = (CartProducts) obj;
		return Objects.equals(created_at, other.created_at) && Objects.equals(productId, other.productId)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(updated_at, other.updated_at);
	}

	
}
