package ar.com.educacionit.clase5;

public class MyExceptionMain {

	public static void main(String[] args) {
		
		int edad = 15;
		
		if(edad < 16) {
			MyRuntimeException error = new MyRuntimeException("Menor de 16");
			throw error; 
		}

		//LOGICA
		
		System.out.println("Voto emitido!!!");
	}

}
