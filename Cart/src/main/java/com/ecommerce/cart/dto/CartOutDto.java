package com.ecommerce.cart.dto;

import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CartOutDto {

	private String cart_id;

	private Long userId;

	private List<CartProductOutDto> cartProductOutDtos;

	@Override
	public int hashCode() {
		return Objects.hash(cartProductOutDtos, cart_id, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartOutDto other = (CartOutDto) obj;
		return Objects.equals(cartProductOutDtos, other.cartProductOutDtos) && Objects.equals(cart_id, other.cart_id)
				&& Objects.equals(userId, other.userId);
	}

}
