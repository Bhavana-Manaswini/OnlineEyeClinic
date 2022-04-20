package com.cg.onlineeyecare.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Component;
@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AppointmentIdNotFoundException extends RuntimeException{
	public AppointmentIdNotFoundException() {
		super();
	}
	public AppointmentIdNotFoundException(String message) {
		super(message);
	}
}