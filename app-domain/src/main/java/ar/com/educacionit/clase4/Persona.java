package ar.com.educacionit.clase4;

/**
 * 1) Crear la clase Persona con los siguientes atributos:
	Es una clase abstracta
	id: int
	nombre, apellido: String
	telefono: Telefono
	domicilio: Domicilio
 * @author CX PC
 *
 */
public abstract class Persona {

	//modificador de visibilidad
	private int id;
	private String nombre;
	private String apellido;
	private Telefono telefono;
	private Domicilio domicilio;
	
	//contructor
	public Persona() {
		
	}

	public Persona(int id, String nombre, String apellido, Telefono telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", domicilio=" + domicilio + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	//get/set
	/**
	 * BONUS: el siguiente ejercicio es un desafío para aquellas personas que han logrado terminar el ejercicio
		anterior de manera rápida
		Crear un método en Persona llamado “public String getNombreCompleto()”. La misión del método es que
		devuelva el nombre y apellido de la persona con la primer letra en mayúscula y el resto en minúscula. Por
		ejemplo, si la persona posee en sus atributos nombre = “juan” y apellido = “PEREZ”, el método
		getNombreCompleto debe devolver: “Juan, Perez”.
	 */
	public String getNombreCompleto() {
		
		//logica para armar this.nombre, this.apellido
		String primerLetra = this.nombre.substring(0, 1).toUpperCase();
		String nombreSinPrimerLetra = this.nombre.substring(1, this.nombre.length()).toLowerCase();
		
		//apellido
		String primerLetraApellido = this.apellido.substring(0, 1).toUpperCase();
		String apellidoSinPrimerLetra = this.apellido.substring(1, this.apellido.length()).toLowerCase();
		
		return primerLetra.concat(nombreSinPrimerLetra).concat(",").concat(primerLetraApellido).concat(apellidoSinPrimerLetra);
	}
}
