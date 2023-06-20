package com.ecommerce.cart.dto;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartInDto {

	private Long userId;
	private String productId;
	private Integer quantity;

	@Override
	public int hashCode() {
		return Objects.hash(productId, quantity, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartInDto other = (CartInDto) obj;
		return Objects.equals(productId, other.productId) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(userId, other.userId);
	}

}
