package ar.com.educacionit.app.domain.clases.abstracta;

import ar.com.educacionit.app.domain.clases.Articulo;

public class BuscadorVacio extends BuscadorBase {

	public BuscadorVacio() {
		super(null);
	}

	@Override
	public void buscar() {
		super.resultados = new Articulo[0];
	}

}
