package ar.com.educacionit.dao.interfaces;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class ConsultaPorTitulo extends AccionBase implements IAccion {

	@Override
	public void ejecutar() {
		
		System.out.print("Ingrese título: ");
		teclado.nextLine();
		String titulo = teclado.nextLine();
		
		try {
			Producto[] productos = dao.search(titulo);
			for(Producto producto : productos) {
				System.out.println(producto);
			}
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
