package ar.com.educacionit.dao.interfaces;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.exceptions.NonExistsExeption;
import ar.com.educacionit.domain.Producto;

public class EliminarProducto extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		
		System.out.print("Ingrese id a eliminar");
		Long id = teclado.nextLong();
		
		try {
			Producto productoEliminado = dao.delete(id);
			System.out.println("Se ha eliminado el producto exitosamente!");
		} catch (NonExistsExeption | GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
