package ar.com.educacionit.app.domain.clases;

import java.util.Scanner;

public class ArticuloMainHelper {

	//metodo de clase
	public static String obtenerClaveDeBusqueda() {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Ingrese articulo a buscar: \t");
		
		String claveBuscadaPorUsuario = teclado.nextLine();
		
		teclado.close();
		
		return claveBuscadaPorUsuario;
	}
	
}
