package ar.com.educacionit.domain;

public class Menu implements Comparable<Menu>{

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

	@Override
	/**
	 * <0
	 * >0
	 * ==0
	 */
	public int compareTo(Menu otroMenu) {

		return this.getDescripcion().compareTo(otroMenu.getDescripcion());
	}
}
