package ar.com.educacionit.domain;

/**
 * 5) Producto
	id;int
	precio: double
	descripción: String
 * @author CX PC
 *
 */
public class Producto {

	private Long id;
	private Float precio;
	private String descripcion;	
	private String codigo;
	private Long tipoProducto;
	
	//dos contructores
	public Producto() {
		
	}

	//alt+shift+s
	public Producto(Long id, Float precio, String descripcion) {
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public Producto(String codigo, String titulo, Float precio, Long tipoProducto) {
		this.codigo = codigo;
		this.descripcion = titulo;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
	}


	@Override
	public String toString() {
		return "Producto {id=" + id + ", precio=" + precio + ", descripcion=" + descripcion + ", codigo=" + codigo
				+ ", tipoProducto=" + tipoProducto + "}";
	}

	//alt+shift+s
	public Producto(Long id, Float precio, String descripcion, String codigo, Long tipoProducto) {
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}

	public Long getId() {
		return id;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	//get/set
	
	//equals
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		
		if(! (obj instanceof Producto)) {
			return false;
		}
		
		Producto otroProducto = (Producto)obj;
		
		boolean iguales = this.id == otroProducto.id;
		
		return iguales;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
