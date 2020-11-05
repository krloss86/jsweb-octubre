package ar.com.educacionit.dao.interfaces;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class ConsultaPorCodigo extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		
		System.out.print("Ingrese codigo a buscar");
		String codigo = teclado.next();
		
		try {
			Producto producto = dao.getByCodigo(codigo);
			System.out.println(producto);
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
