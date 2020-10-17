package ar.com.educacionit.app.domain.clases;

public class Articulo {

	//atributos
	protected String titulo;
	protected float precio;
	protected String catogoria;
	protected String autor;
	
	//agregamos atributo
	private String urlImagen;
	private String[] urlMasImagenes;
	
	public Articulo() {
	
	}
	
	//alt+shift+s
	public Articulo(String titulo, float precio, String catogoria, String autor) {
		this.titulo = titulo;
		this.precio = precio;
		this.catogoria = catogoria;
		this.autor = autor;
	}
	
//	@Override
//	protected void finalize() throws Throwable {
//		super.finalize();
//	}
	
	//metodos
	public boolean tieneImagen() {
		return this.urlImagen != null;
	}
	

	public boolean tieneMasImagenes() {
		return this.urlMasImagenes !=null;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		if(precio < 0) {
			this.precio = 0;
		}else {
			this.precio = precio;
		}
	}

	public String getCatogoria() {
		//libRO -> LIBRO
		//Libro -> LIBRO
		
		return catogoria.toUpperCase();
	}

	public void setCatogoria(String catogoria) {
		this.catogoria = catogoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String[] getUrlMasImagenes() {
		return urlMasImagenes;
	}

	public void setUrlMasImagenes(String[] urlMasImagenes) {
		this.urlMasImagenes = urlMasImagenes;
	}
	
	//getter/setter
	//alt+shit+s
	
}
