package com.ecommerce.payment.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.payment.domain.ErrorResponse;

/**
 * @author sarang 
 * The ApplicationExceptionHandler is used to handle all kinds
 *  of exception.
 */
@RestControllerAdvice
public class ApplicationExceptionHandler {

	/**
	 * @param ex used to store exception object
	 * @return RecordNotFoundException - used when a record is not found.
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(final RecordNotFoundException ex) {
		List<String> errorMessages = new ArrayList<String>();
		errorMessages.add(ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), errorMessages);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param ex
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidDetailsException.class)
	public final ResponseEntity<ErrorResponse> handleInvalidXMLException(final InvalidDetailsException ex) {
		List<String> errorMessages = new ArrayList<String>();
		errorMessages.add(ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessages);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param ex
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(RecordAlreadyExistsException.class)
	public final ResponseEntity<ErrorResponse> handleRecordAlreadyExistException(
			final RecordAlreadyExistsException ex) {
		List<String> errorMessages = new ArrayList<String>();
		errorMessages.add(ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), errorMessages);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);

	}
}
