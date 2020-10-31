package ar.com.educacionit.dao;

import ar.com.educacionit.clase4.Producto;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;

public class TestInsertProducto {

	public static void main(String[] args) {
		
		Producto nuevoProducto = new Producto("0004","Teclado Logitech",new Float(2400),new Long(1));
		
		ProductoDAO pdao = new ProductoDAO();
		
		try {
			pdao.insert(nuevoProducto);
			System.out.println("OK");
		} catch (DuplicatedException e) {
			System.err.println("FAIL");
			e.printStackTrace();
		} catch (GenericException e) {
			System.err.println("FAIL");
			e.printStackTrace();
		}
	}

}
