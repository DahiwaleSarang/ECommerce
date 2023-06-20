package com.ecommerce.cart.entity;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
    /**
     * The errorCode - stores response error code.
     */
    private Integer errorCode;

    /**
     * The errorMessages - stores list of error messages.
     */
    private List<String> errorMessages;

	@Override
	public int hashCode() {
		return Objects.hash(errorCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		return Objects.equals(errorCode, other.errorCode);
	}
    
    

}
