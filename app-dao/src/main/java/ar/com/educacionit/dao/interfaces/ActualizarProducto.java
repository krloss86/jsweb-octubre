package ar.com.educacionit.dao.interfaces;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.exceptions.NonExistsExeption;
import ar.com.educacionit.domain.Producto;

public class ActualizarProducto extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		
		System.out.println("Ingrese código a buscar");
		String codigo = teclado.next();
		
		try {
			Producto producto = dao.getByCodigo(codigo);
			//--------------------------------------------
			System.out.println("Ingrese datos a actualizar.");
			System.out.print("Ingrese Título:");
			String titulo = teclado.next();
			System.out.print("Ingrese Precio:");
			Float precio = teclado.nextFloat();
			System.out.print("Ingrese TipoProducto:");
			Long tipoProducto = teclado.nextLong();
			
			// actualizar el producto que consutamos previamente
			// "setear" los atributos titulo, precio y tipoProducto
			
			producto.setPrecio(precio);
			producto.setDescripcion(titulo);
			producto.setTipoProducto(tipoProducto);
			
			Producto productoActualizado = dao.update(producto);
			
			System.out.println("Se ha actualizado el producto exitosamente!");
		} catch (NonExistsExeption | GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
