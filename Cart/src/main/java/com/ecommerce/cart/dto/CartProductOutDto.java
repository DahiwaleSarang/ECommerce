package com.ecommerce.cart.dto;

import java.time.Instant;
import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartProductOutDto {
	
	private String id;
	private String name;
	private String description;
	private Integer quantity;
	private double price;
	private double discount;
	private String manufacturer;
	
	@Override
	public int hashCode() {
		return Objects.hash(description, discount, id, manufacturer, name, price, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProductOutDto other = (CartProductOutDto) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(discount) == Double.doubleToLongBits(other.discount)
				&& Objects.equals(id, other.id) && Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(quantity, other.quantity);
	}
	
	

}
