package ar.com.educacionit.dao.interfaces;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.exceptions.NonExistsExeption;
import ar.com.educacionit.domain.Producto;

public class ActualizarPrecio extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		
		System.out.println("Ingrese código a buscar");
		String codigo = teclado.next();
		
		try {
			Producto producto = dao.getByCodigo(codigo);
			System.out.println(producto);//ctrl+shit+i
			//--------------------------------------------
			System.out.println("Ingrese nuevo precio.");
			Float nuevoPrecio = teclado.nextFloat();
			producto.setPrecio(nuevoPrecio);
			
			Producto productoActualizado = dao.update(producto);
			
			System.out.println("Se ha actualizado el precio exitosamente!");
			System.out.println(productoActualizado);//ctrl+shit+i
		} catch (NonExistsExeption | GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
