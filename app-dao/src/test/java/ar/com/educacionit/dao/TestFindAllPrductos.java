package ar.com.educacionit.dao;

import java.util.Collection;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class TestFindAllPrductos {

	public static void main(String[] args) {
		
		ProductoDAO pdao =  new ProductoDAO();
		
		try {
			Collection<Producto> productos = pdao.findProductos();
			System.out.println("OK");
		} catch (GenericException e) {
			e.printStackTrace();
			System.err.println("FAIL");
		}
	}

}
