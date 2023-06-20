package com.ecommerce.user.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.user.entity.ErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	 /**
     * @param ex used to store exception object
     * @return RecordNotFoundException - used when a record is not found.
     */
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(final UserNotFoundException ex) {
        List<String> errorMessages = new ArrayList<String>();
        errorMessages.add(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), errorMessages);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    /**
     * @param ex used to store exception object
     * @return RecordNotFoundException - used when a record is not found.
     */
    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(UserExistsException.class)
    public final ResponseEntity<ErrorResponse> handleUserExistsException(final UserExistsException ex) {
        List<String> errorMessages = new ArrayList<String>();
        errorMessages.add(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), errorMessages);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
    }
 
   
}
