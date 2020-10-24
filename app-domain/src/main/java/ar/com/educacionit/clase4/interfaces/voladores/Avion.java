package ar.com.educacionit.clase4.interfaces.voladores;

public class Avion extends Volador implements Aterrizable {
	
	public Avion(String nombre) {
		super(nombre);
	}

	@Override
	public boolean tieneTurbina() {		
		return true;
	}

	//cumple el contrato, implementando el metodo aterrizar()
	@Override
	public void aterrizar() {
		System.err.println("Aterrizando " + this.getNombre());
	}
}
