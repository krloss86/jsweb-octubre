package ar.com.educacionit.app.domain.clases.abstracta;

import ar.com.educacionit.app.domain.clases.Articulo;

public abstract class BuscadorBase {

	protected String clave;
	protected Articulo[] resultados;
	
	public BuscadorBase(String clave) {
		this.clave = clave;
	}

	//obliga a los hijos a definir el metodo buscar
	public abstract void buscar();

	public Articulo[] getResultados() {
		return resultados;
	}
	
	public int cantidadResultados()  {
		int cantidad = 0;
		if(this.resultados != null) {
			cantidad = this.resultados.length;
		}
		return cantidad;
	}
}
