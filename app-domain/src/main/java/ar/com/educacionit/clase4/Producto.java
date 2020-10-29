package ar.com.educacionit.clase4;

/**
 * 5) Producto
	id;int
	precio: double
	descripción: String
 * @author CX PC
 *
 */
public class Producto {

	private Integer id;
	private Double precio;
	private String descripcion;
	
	private String codigo;
	private Long tipoProducto;
	
	//dos contructores
	public Producto() {
		
	}

	//alt+shift+s
	public Producto(int id, double precio, String descripcion) {
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public Producto(String codigo, String titulo, Double precio, Long tipoProducto) {
		this.codigo = codigo;
		this.descripcion = titulo;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", precio=" + precio + ", descripcion=" + descripcion + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
