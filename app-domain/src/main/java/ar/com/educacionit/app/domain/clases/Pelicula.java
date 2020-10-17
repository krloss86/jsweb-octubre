package ar.com.educacionit.app.domain.clases;

public class Pelicula extends Articulo {

	private double duracion;

	public Pelicula(String titulo, float precio, String catogoria, String autor, long duracion) {
		//nace el padre
		super(titulo, precio, catogoria, autor);
		
		//los atributos propios = this del hijo
		this.duracion = duracion;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
}
