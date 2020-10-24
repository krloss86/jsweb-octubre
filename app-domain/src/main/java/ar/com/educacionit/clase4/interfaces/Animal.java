package ar.com.educacionit.clase4.interfaces;

public class Animal extends Mamifero {

	private String especie;
	
	public Animal(String especie) {
		this.especie = especie;
	}
	
	@Override
	public String hablar() {
		return this.especie + " hablando";
	}
}
