package com.register.Exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;
}
