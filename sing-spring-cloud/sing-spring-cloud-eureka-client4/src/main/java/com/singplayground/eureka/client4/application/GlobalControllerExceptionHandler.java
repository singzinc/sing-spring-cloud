package com.singplayground.eureka.client4.application;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice("com.singplayground.eureka.client4.controller")
@RequestMapping(produces = "application/vnd.error+json") 
class GlobalControllerExceptionHandler {
   
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// error handler 
	 private ResponseEntity < VndErrors > error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
	        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
	        return new ResponseEntity < > (new VndErrors(logRef, message), httpStatus);
	    }
	
	
	 @ExceptionHandler(IllegalArgumentException.class) 
	 public ResponseEntity < VndErrors > assertionException(final IllegalArgumentException e) {
		 logger.error("this is error ");   
		 return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
	     
		 //   return new ResponseEntity < > (new VndErrors(logRef, message), httpStatus);   
	 }
	 /*
	 @ExceptionHandler(IOException.class) 
	 public ResponseEntity < VndErrors > assertionxException(final IllegalArgumentException e) {
		 logger.error("this is error bad request ");   
		 return error(e, HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
	     
		 //   return new ResponseEntity < > (new VndErrors(logRef, message), httpStatus);   
	 }
	*/
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		
		logger.error("xxx IOException handler executed");
		//returning 404 error code
	}
	
	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
	        return new ResponseEntity<Object>(
	          "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Other Exception occured")
	/* custom error message  */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity < VndErrors > handleException(Exception ex, WebRequest request) {
		logger.error("xxx Exception handler executed : " + request.toString());
		
		 return error(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
	}
	
}
