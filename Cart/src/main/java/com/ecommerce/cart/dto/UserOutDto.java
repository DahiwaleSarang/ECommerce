package com.ecommerce.cart.dto;

import java.time.Instant;
import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserOutDto {

    private Long id;
	
    private Long sellerId;
    
    private String firstName;
    
    private String gender;
    
    private String lastName;
    
    private String phone;
    
    private String countryCode;
    
    private String emailId;
    
    private Instant createdDt;
    
    private String addressLine1;
    
    private String addressLine2;
    
    private String city;
    
    private String state;
    
    private String country;
    
    private String postalCode;
    
    private boolean isSeller;

	@Override
	public int hashCode() {
		return Objects.hash(addressLine1, addressLine2, city, country, countryCode, createdDt, emailId, firstName,
				gender, id, isSeller, lastName, phone, postalCode, sellerId, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserOutDto other = (UserOutDto) obj;
		return Objects.equals(addressLine1, other.addressLine1) && Objects.equals(addressLine2, other.addressLine2)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(countryCode, other.countryCode) && Objects.equals(createdDt, other.createdDt)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id) && isSeller == other.isSeller
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(sellerId, other.sellerId)
				&& Objects.equals(state, other.state);
	}
    
    
}
