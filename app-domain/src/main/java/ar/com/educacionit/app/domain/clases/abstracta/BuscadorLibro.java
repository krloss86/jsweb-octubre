package ar.com.educacionit.app.domain.clases.abstracta;

import ar.com.educacionit.app.domain.clases.Articulo;
import ar.com.educacionit.app.domain.clases.Libro;

public class BuscadorLibro extends BuscadorBase {

	public BuscadorLibro(String clave) {
		super(clave);
	}

	@Override
	public void buscar() {
		
		Libro libro = new Libro("0001","carlos", 1500f, "libro", this.clave, "1234567890");
		libro.setUrlImagen("http://tmk.com.ar/imagen/123456.jpg");

		Libro libro2 = new Libro("0002","juan", 1800f, "libro", this.clave, "1234567890");
		libro2.setUrlImagen("http://tmk.com.ar/imagen/123456.jpg");
		
		//seteo en el padre el vector de resultados
		super.resultados = new Libro[] {libro, libro2};
	}

}
