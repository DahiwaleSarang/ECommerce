package com.ecommerce.product.dto;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductInDto {

    private String name;
    private String description;
    private Integer quantity;
    private double price;
    private double discount;
    private String manufacturer;
    
	@Override
	public int hashCode() {
		return Objects.hash(description, discount, manufacturer, name, price, quantity);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInDto other = (ProductInDto) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(discount) == Double.doubleToLongBits(other.discount)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(quantity, other.quantity);
	}
    
    
}
