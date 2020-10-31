package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class TestConnection {

	/**
	 * Test Case de AdminstradorDeConexiones
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Connection conn = AdminstradorDeConexiones.obtenerConexion();
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("FAIL");
			}
			System.out.println("OK");
		} catch (GenericException e) {
			System.err.println("FAIL");
		};
	}

}
