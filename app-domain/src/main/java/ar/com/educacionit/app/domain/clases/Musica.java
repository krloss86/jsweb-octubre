package ar.com.educacionit.app.domain.clases;

import java.util.Date;

public class Musica extends Articulo {

	private String selloDiscografico;
	private String formato;
	private String clasificacion;
	private Date fechaPublicacion;
	
	public Musica(String codigo, String titulo, float precio, String catogoria, String autor) {
		super(codigo, titulo, precio, catogoria, autor);
	}

	public String getSelloDiscografico() {
		return selloDiscografico;
	}

	public void setSelloDiscografico(String selloDiscografico) {
		this.selloDiscografico = selloDiscografico;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	//alt+shif+s
	
}
