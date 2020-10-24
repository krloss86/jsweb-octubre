package ar.com.educacionit.clase4.interfaces.voladores;

public class Ovni extends Volador {
	
	public Ovni(String nombre) {
		super(nombre);
	}

	@Override
	public boolean tieneTurbina() {		
		return false;
	}

	public void aterrizar() {
		System.out.println(this.getNombre() + " aterrizando");
	}
}
