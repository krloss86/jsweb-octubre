package ar.com.educacionit.app.domain.clases;

public class Pelicula extends Articulo {

	private double duracion;

	public Pelicula(String codigo, String titulo, float precio, String catogoria, String autor, long duracion) {
		//nace el padre
		super(codigo, titulo, precio, catogoria, autor);
		
		//los atributos propios = this del hijo
		this.duracion = duracion;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	//polimorfismo con redefinicion
	@Override
	public void informar() {
		
		super.informar();
		
		System.out.println("Duración: " + this.getDuracion());
	}
}
