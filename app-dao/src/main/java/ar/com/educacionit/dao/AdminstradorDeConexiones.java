package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdminstradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		
		//paso1 nombre del Driver que usaremos
		String driver = "com.mysql.jdbc.Driver";
		
		String dbConnectionString = "jdbc:mysql://127.0.0.1:3306/jsweb-octubre?serverTimezone=UTC";
		
		//username
		String username = "root";
		
		//password
		String password = "root";
		
		//Establece el driver de conexion
		try {
			Class.forName(driver).newInstance();
			
			//retornar la conexion
			Connection connection = DriverManager.getConnection(dbConnectionString,username, password);
			
			return connection;
		}catch (Exception e) {
			throw new GenericException("No se ha podido obtener conexion: " + dbConnectionString+ ", username:"+username + ", passowrd:"+password, e);
		}
	}
}
