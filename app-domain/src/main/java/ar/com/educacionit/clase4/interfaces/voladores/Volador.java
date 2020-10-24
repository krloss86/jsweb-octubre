package ar.com.educacionit.clase4.interfaces.voladores;

public abstract class Volador {

	private String nombre;
	
	public Volador(String nombre) {
		this.nombre = nombre;
	}
	
	//los hijos dicen si tiene o no turbina
	public abstract boolean tieneTurbina();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public final void piruetas() {
		System.out.println(this.nombre + " haciendo piruetas");
	}
}
