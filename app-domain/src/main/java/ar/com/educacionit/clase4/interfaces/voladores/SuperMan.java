package ar.com.educacionit.clase4.interfaces.voladores;

public final class SuperMan extends Volador implements Aterrizable{
	
	public SuperMan() {
		super("Clark Ken");
	}

	@Override
	public boolean tieneTurbina() {		
		return false;
	}

	@Override
	public void aterrizar() {
		System.out.println(this.getNombre() + " bajando de los cielos");
	}
		
}
