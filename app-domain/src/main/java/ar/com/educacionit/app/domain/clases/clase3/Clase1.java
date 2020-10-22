package ar.com.educacionit.app.domain.clases.clase3;

public class Clase1 extends ClaseBase {

	private float altura;
	
	public Clase1(String nombre, int edad) {
		super(nombre, edad);
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

}
