package ar.com.educacionit.app.domain.clases;

public final class Libro extends Articulo {

	private String isbn;
	
	public Libro(String codigo, String titulo, float precio, String catogoria, String autor, String isbn) {
		//nace el padre
		super(codigo, titulo, precio, catogoria, autor);
		
		//los atributos propios = this del hijo
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
