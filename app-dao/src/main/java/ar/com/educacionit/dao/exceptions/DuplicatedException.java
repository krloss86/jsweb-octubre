package ar.com.educacionit.dao.exceptions;

public class DuplicatedException extends Exception {

	public DuplicatedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DuplicatedException(String arg0) {
		super(arg0);
	}

	
}
