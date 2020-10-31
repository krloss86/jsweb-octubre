package ar.com.educacionit.dao;

import ar.com.educacionit.dao.exceptions.GenericException;

public class TestGetProductoByCodigo {

	public static void main(String[] args) {
		
		String codigo = "0001";
		
		ProductoDAO pdao = new ProductoDAO();
		
		try {
			pdao.getByCodigo(codigo);
			System.out.println("OK");
		} catch (GenericException e) {
			e.printStackTrace();
			System.err.println("FAIL");
		}
	}
}
