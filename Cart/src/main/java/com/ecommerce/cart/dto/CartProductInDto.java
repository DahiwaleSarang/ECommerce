package com.ecommerce.cart.dto;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CartProductInDto {

	private String product_id;

	private int quantity;

	@Override
	public int hashCode() {
		return Objects.hash(product_id, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProductInDto other = (CartProductInDto) obj;
		return Objects.equals(product_id, other.product_id) && quantity == other.quantity;
	}

}
