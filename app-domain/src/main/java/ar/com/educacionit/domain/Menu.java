package ar.com.educacionit.domain;

public class Menu {

	private Integer opcion;
	
	private String  descripcion;

	public Menu(Integer opcion, String descripcion) {
		this.opcion = opcion;
		this.descripcion = descripcion;
	}

	public Integer getOpcion() {
		return opcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
