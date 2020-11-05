package ar.com.educacionit.dao.interfaces;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDAO;

public abstract class AccionBase {

	protected ProductoDAO dao;
	protected Scanner teclado;
	
	public AccionBase() {
		this.dao = new ProductoDAO();
		this.teclado = new Scanner(System.in);
	}
}
