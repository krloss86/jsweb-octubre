package ar.com.educacionit.app.domain.clases.clase3;

public class ClaseBase {

	protected String nombre;

	private int edad;
	
	public ClaseBase(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String informar() {
		return null;
	}
}
