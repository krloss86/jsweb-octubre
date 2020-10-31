package ar.com.educacionit.dao;

import java.util.Scanner;

import ar.com.educacionit.clase4.Producto;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;

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
				
				try {
					opcion = teclado.nextInt();
				}catch (Exception e) {
					System.err.println("Opcion inválida");
				}
			}while(opcion == null);
	
			if(opcion.equals(1)) {
				System.out.print("Ingrese codigo:");
				String codigo = teclado.next();
				System.out.print("Ingrese Título:");
				String titulo = teclado.next();
				System.out.print("Ingrese Precio:");
				Float precio = teclado.nextFloat();
				System.out.print("Ingrese TipoProducto:");
				Long tipoProducto = teclado.nextLong();
				
				Producto productoNuevo = new Producto(codigo, titulo, precio, tipoProducto);
				
				ProductoDAO pdao = new ProductoDAO();
				try {
					productoNuevo = pdao.insert(productoNuevo);
					System.out.println(productoNuevo);
				} catch (DuplicatedException | GenericException e) {
					System.err.println("No se ha podido crear el producto" + e.getMessage());
				} 
			}else if(opcion.equals(2)) {
				System.out.print("Ingrese codigo a buscar");
				String codigo = teclado.next();
				
				ProductoDAO pdao = new ProductoDAO();
				try {
					Producto producto = pdao.getByCodigo(codigo);
					System.out.println(producto);
				} catch (GenericException e) {
					System.err.println(e.getMessage());
				}
			}else if(opcion.equals(3)) {
				ProductoDAO pdao = new ProductoDAO();
				try {
					Producto[] productos = pdao.findProductos();
					for(Producto producto : productos) {
						System.out.println(producto);
					}
				} catch (GenericException e) {
					System.err.println(e.getMessage());
				}
			}
			
			System.out.println("------------------------------------------------------------");
			System.out.println("Desea continuar?");
			System.out.println("S/N");
			
			String opcionContinuar = teclado.next();
			continuar = "S".equalsIgnoreCase(opcionContinuar);
			// teclado.next();
		}while(continuar);
		
		teclado.close();
		System.out.println("FIN");
	}

}
