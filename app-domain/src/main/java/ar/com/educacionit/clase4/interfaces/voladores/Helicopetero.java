package ar.com.educacionit.clase4.interfaces.voladores;

public class Helicopetero extends Volador implements Aterrizable {
	
	public Helicopetero(String nombre) {
		super(nombre);
	}

	@Override
	public boolean tieneTurbina() {		
		return false;
	}

	@Override
	public void aterrizar() {
		System.out.println("Aterrizando " + this.getNombre());
	}
}
