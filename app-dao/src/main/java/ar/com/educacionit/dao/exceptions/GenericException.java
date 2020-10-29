package ar.com.educacionit.dao.exceptions;

public class GenericException extends Exception {

	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericException(String message) {
		super(message);
	}

	
}
