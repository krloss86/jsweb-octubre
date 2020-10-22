package ar.com.educacionit.app.domain.clases.abstracta;

import ar.com.educacionit.app.domain.clases.Pelicula;

public class BuscadorPelicula extends BuscadorBase {

	public BuscadorPelicula(String clave) {
		super(clave);
	}

	@Override
	public void buscar() {

		// PADRE P = NEW HIJO()
		Pelicula pelicula = new Pelicula("0002", this.clave, new Float(1750), "PELICULA", "Autor xyz", 2);
		pelicula.setUrlImagen("http://tmk.com.ar/imagen/748596.jpg");

		String[] masImagenesPelicula = new String[2];
		masImagenesPelicula[0] = "http://tmk.com.ar/imagen/7485967.jpg";
		masImagenesPelicula[1] = "http://tmk.com.ar/imagen/74859678.jpg";

		pelicula.setUrlMasImagenes(masImagenesPelicula);

		// PADRE P = NEW HIJO()
		Pelicula pelicula2 = new Pelicula("0002", this.clave, new Float(1750), "PELICULA", "Autor xyz", 2);
		pelicula2.setUrlImagen("http://tmk.com.ar/imagen/748596.jpg");

		String[] masImagenesPelicula2 = new String[2];
		masImagenesPelicula2[0] = "http://tmk.com.ar/imagen/7485967.jpg";
		masImagenesPelicula2[1] = "http://tmk.com.ar/imagen/74859678.jpg";

		pelicula.setUrlMasImagenes(masImagenesPelicula);

		// seteo en el padre el vector de resultados
		super.resultados = new Pelicula[] { pelicula, pelicula2};
	}

}
