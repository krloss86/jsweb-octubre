package ar.com.educacionit.app.domain.clases.abstracta;

import ar.com.educacionit.app.domain.clases.Articulo;
import ar.com.educacionit.app.domain.clases.ArticuloMainHelper;

public class BuscadorMain {

	public static void main(String[] args) {
		
		//simular los filtros que cargo el usuario
		int[] tipoBuscadores = new int[] {1,2};
		
		String claveBusqueda  = ArticuloMainHelper.obtenerClaveDeBusqueda();

		BuscadorBase[] buscadores = GenereradorBuscadores.generarBuscadores(tipoBuscadores, claveBusqueda);
		
		Presentador presentador = new Presentador();

		//ejecutar cada una de las busquedas y tomar los resultados
		for(BuscadorBase buscador : buscadores) {
			
			buscador.buscar();
			
			Articulo[] resultados = buscador.getResultados();
			
			presentador.agregarResultados(resultados);
		}
		
		presentador.presentar();
	}

}
