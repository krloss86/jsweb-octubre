package ar.com.educacionit.clase5;

public class MyRuntimeException extends RuntimeException {

	//alt+shit+s
	public MyRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MyRuntimeException(String message) {
		super(message);
	}
	
}
