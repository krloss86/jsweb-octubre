package ar.com.educacionit.dao;

import java.util.Scanner;

import ar.com.educacionit.dao.builder.ProductoAccionBuilder;
import ar.com.educacionit.dao.interfaces.IAccion;

public class ABMProductos {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		boolean continuar = false;
		
		do {
			Integer opcion = null;
			do {
				System.out.println("Ingrese una opcion Válida");
				System.out.println("1 - Crear Producto");
				System.out.println("2 - Consultar por Codigo");
				System.out.println("3 - Consultar todos");
				System.out.println("4 - Eliminar producto");
				System.out.println("5 - Actualizar producto");
				System.out.println("6 - Consultar por ID");
				System.out.println("7 - Búsqueda por título");
				
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
