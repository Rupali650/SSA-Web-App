package com.rupali.exceptionhandler;
    
	import java.util.Date;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	import com.rupali.customexception.InvalidSocialSecurityNumberException;
	import com.rupali.error.ApiError;


	@ControllerAdvice
	public class InvalidSocialSecurityNumberExceptionHandler {
		
		@ExceptionHandler(value = InvalidSocialSecurityNumberException.class)
		public ResponseEntity<?> ExceptionHandler() {
			ApiError error = new ApiError(400,"Invalid SSN",new Date());
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
			
		}

	}
	
