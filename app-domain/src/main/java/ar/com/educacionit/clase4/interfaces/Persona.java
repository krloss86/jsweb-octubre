package ar.com.educacionit.clase4.interfaces;

public class Persona extends Mamifero implements ICantante {

	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public String hablar() {
		return this.nombre + " hablando";
	}

	public void cantar() {
		String canto = this.nombre + " está cantando!!!";
		System.out.println(canto);
	}

}
