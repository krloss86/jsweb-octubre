package ar.com.educacionit.app.domain.clases;

public class Buscador {

	//atributos
	private String claveBusqueda;
	private Articulo[] resultados;
	
	//contructor
	public Buscador() {
		
	}
	
	public Buscador(String claveBuscada) {
		this.claveBusqueda = claveBuscada;
	}
	
	public void buscar() {
		//realiza la consulta  y actualiza el listado
		//de articulos interno
		
		//PADRE P = NEW HIJO()
		
		Articulo libro = new Libro("carlos", 1500f, "libro", this.claveBusqueda, "1234567890");
		libro.setUrlImagen("http://tmk.com.ar/imagen/123456.jpg");
		
		//PADRE P = NEW HIJO()
		Articulo pelicula = new Pelicula(this.claveBusqueda, new Float(1750), "PELICULA", "Autor xyz", 2);
		pelicula.setUrlImagen("http://tmk.com.ar/imagen/748596.jpg");
		
		String[] masImagenesPelicula = new String[2];
		masImagenesPelicula[0] = "http://tmk.com.ar/imagen/7485967.jpg";
		masImagenesPelicula[1] = "http://tmk.com.ar/imagen/74859678.jpg";
		
		pelicula.setUrlMasImagenes(masImagenesPelicula);
		
		//actualizo el atributo interno resultados
		this.resultados = new Articulo[]{libro, pelicula};
		
		/*this.resultados = new Articulo[2];
		this.resultados[0] = libro;
		this.resultados[1] = pelicula;*/
	}
	
	public Integer getCantResult() {
		if(this.resultados != null) {
			return this.resultados.length;
		}else {
			return 0;
		}
	}
	
	//get/set
	public Articulo obtenerArticuloPorPosicion(int posicion) {
		if(posicion < 0 || posicion > this.resultados.length) {
			return null;
		}
		return this.resultados[posicion];
	}

	public String getClaveBusqueda() {
		return claveBusqueda;
	}

	public void setClaveBusqueda(String claveBusqueda) {
		this.claveBusqueda = claveBusqueda;
	}
	
}
