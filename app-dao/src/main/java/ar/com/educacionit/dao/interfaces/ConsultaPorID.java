package ar.com.educacionit.dao.interfaces;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class ConsultaPorID extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		
		System.out.print("Ingrese ID a buscar");
		Long id = teclado.nextLong();
		
		try {
			Producto producto = dao.getById(id);
			System.out.println(producto);
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
