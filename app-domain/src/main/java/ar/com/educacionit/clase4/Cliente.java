package ar.com.educacionit.clase4;

/**
 * 4) Cliente (Hereda de Persona)
	numeroCliente: int
 * @author CX PC
 *
 */
public class Cliente extends Persona {
	
	private int numeroCliente;
	
	//vacio
	public Cliente() {
		
	}

	public Cliente(int id, String nombre, String apellido, Telefono telefono, int numeroCliente) {
		
		//padre
		super(id, nombre, apellido, telefono);
		
		//propio
		this.numeroCliente = numeroCliente;
	}

	@Override
	public String toString() {
		
		String toStringPadre = super.toString();
		
		return toStringPadre +  ", Cliente [numeroCliente=" + numeroCliente + "]";
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
}
