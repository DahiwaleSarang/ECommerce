package com.ecommerce.product.entity;

import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "product")
@AllArgsConstructor
public class Product {

	@Id
	private String id;
	private Long userId;
	private String name;
	private String description;
	private int quantity;
	private double price;
	private double discount;
	private String manufacturer;
	private Instant createdAt;
	private Instant updatedAt;

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, description, discount, id, manufacturer, name, price, quantity, updatedAt,
				userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(description, other.description)
				&& Double.doubleToLongBits(discount) == Double.doubleToLongBits(other.discount)
				&& Objects.equals(id, other.id) && Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(userId, other.userId);
	}

	

}
