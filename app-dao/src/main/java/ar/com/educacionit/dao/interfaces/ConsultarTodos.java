package ar.com.educacionit.dao.interfaces;

import java.util.Collection;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class ConsultarTodos extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		//ctrl+shift+o
		try {
			Collection<Producto> productos = dao.findProductos();
			for(Producto producto : productos) {
				System.out.println(producto);
			}
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
