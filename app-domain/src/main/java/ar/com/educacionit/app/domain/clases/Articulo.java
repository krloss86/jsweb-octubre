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
	
	protected String codigo;
	
	//alt+shift+s
	public Articulo(String codigo, String titulo, float precio, String catogoria, String autor) {
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void informar() {
		//mostar los datos del articulo
		System.out.println("Titulo: " + this.getTitulo());
		System.out.println("Autor: " + this.getAutor());
		System.out.println("Precio: " + this.getPrecio());
		System.out.println("Categoria: " + this.getCatogoria());
		
		if(this.tieneImagen()) {
			System.out.println("Imagen: " + this.getUrlImagen());
		}else {
			System.out.println("Imagen Generica");
		}
		
		if(this.tieneMasImagenes()) {
			for(String imagen : this.getUrlMasImagenes()) {
				System.out.println("Imagen: " + imagen);
			}
		}
	}
	//getter/setter
	//alt+shit+s
	
}
