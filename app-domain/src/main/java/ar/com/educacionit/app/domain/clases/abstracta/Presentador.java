package ar.com.educacionit.app.domain.clases.abstracta;

import ar.com.educacionit.app.domain.clases.Articulo;

public class Presentador {

	private Articulo[] resultados;

	/*public Presentador(Articulo[] resultados) {
		this.resultados = resultados;
	}*/
	
	public void agregarResultados(Articulo[] resultados) {//10
		if(this.resultados == null) {
			this.resultados = resultados;
		}else {
			
			Articulo[] aux = new Articulo[this.resultados.length + resultados.length];
			int i;
			for(i = 0; i < this.resultados.length; i ++ ) {
				aux[i] = this.resultados[i];
			}
			for(int j = i, k = 0; j < aux.length; j++, k++ ) {
				aux[j] = resultados[k];
			}
			this.resultados = aux;
		}
	}

	public void presentar() {
		
		for(Articulo resultado : this.resultados) {
			
			resultado.informar();
			
			System.out.println("------------");
		}
	}

}
