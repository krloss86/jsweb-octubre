package ar.com.educacionit.app.domain.clases.abstracta;

public class GenereradorBuscadores {

	public static BuscadorBase[] generarBuscadores(int[] tipoBuscadores, String claveBusqueda) {
		
		BuscadorBase[] buscadores = new BuscadorBase[tipoBuscadores.length];
		
		for(int i = 0; i < tipoBuscadores.length; i++) {
			if(tipoBuscadores[i] == 1) {
				BuscadorLibro bl = new BuscadorLibro(claveBusqueda);
				buscadores[i] = bl;
			}else if(tipoBuscadores[i] == 2) {
				BuscadorPelicula bp = new BuscadorPelicula(claveBusqueda);
				buscadores[i] = bp;
			}else {
				BuscadorVacio bv = new BuscadorVacio();
				buscadores[i] = bv;
			}
		}
		
		return buscadores;
	}

}
