package com.org.exception;

public class ActorNotFoundException extends RuntimeException {

	public ActorNotFoundException() {
		super();
	}
	
	public ActorNotFoundException(String message) {
		super(message);
	}
}
