package ar.com.educacionit.dao.interfaces;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class CrearProducto extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		
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
	}

}
