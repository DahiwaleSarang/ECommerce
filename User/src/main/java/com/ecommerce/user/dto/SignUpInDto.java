package com.ecommerce.user.dto;

import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sarang
 *
 */
/**
 * @author Sarang
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInDto {

	private String firstName;

	private String gender;

	private String lastName;

	private String phone;

	private String countryCode;

	private String email;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private String country;

	private String postalCode;

	private String role;

	private char[] password;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + Objects.hash(addressLine1, addressLine2, city, country, countryCode, email, firstName,
				gender, lastName, phone, postalCode, role, state);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUpInDto other = (SignUpInDto) obj;
		return Objects.equals(addressLine1, other.addressLine1) && Objects.equals(addressLine2, other.addressLine2)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(countryCode, other.countryCode) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(lastName, other.lastName) && Arrays.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(role, other.role) && Objects.equals(state, other.state);
	}

	
}
