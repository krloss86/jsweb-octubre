package ar.com.educacionit.clase5;

import java.util.Scanner;

public class ExceptionMain {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		Integer edad = null;
		
		do {
			System.out.println("Ingrese Edad");
			try {			
				edad = teclado.nextInt();			
			}catch (Exception e) {			
				System.err.println("Edad Inválida");
				teclado.next();
			} 
		}while(edad == null);
		
		teclado.close();
		
		//tengo edad entero valido
	}

}
