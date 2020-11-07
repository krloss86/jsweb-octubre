package ar.com.educacionit.dao;

import java.util.Scanner;

import ar.com.educacionit.dao.builder.ProductoAccionBuilder;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.interfaces.IAccion;

public class ABMProductos {

	public static void main(String[] args) throws GenericException {
		Scanner teclado = new Scanner(System.in);
		
		boolean continuar = false;
		
		String menu = MenuBuilder.textoMenu();
			
		do {
			Integer opcion = null;
			do {
				System.out.println(menu);
				
				try {
					opcion = teclado.nextInt();
				}catch (Exception e) {
					System.err.println("Opcion inválida");
				}
			}while(opcion == null);
	
			IAccion accion = ProductoAccionBuilder.buildAccion(opcion);
			
			accion.ejecutar();
			
			System.out.println("------------------------------------------------------------");
			System.out.println("Desea continuar?");
			System.out.println("S/N");
			
			String opcionContinuar = teclado.next();
			continuar = "S".equalsIgnoreCase(opcionContinuar);
		}while(continuar);
		
		teclado.close();
		System.out.println("FIN");
	}

}
