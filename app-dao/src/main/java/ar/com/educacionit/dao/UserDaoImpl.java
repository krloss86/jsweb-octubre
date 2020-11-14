package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.User;

public class UserDaoImpl implements UserDao {

	/**
	 * Obtiene un usuario dado su username
	 */
	public User getByUserName(String user) throws GenericException {
			
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		//sql buscar usuario por username
		
		String  sql = "SELECT * FROM users WHERE upper(username) = '"+user+"'";
		
		Statement statement;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}
		
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			User usuario = null;
			if(resultSet.next()) {
				Long id = resultSet.getLong(1);
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				usuario = new User(id, username, password);
			}

			return usuario;
			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el usuario, username:"+user, e);
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("NO se pudo cerrar la conexion, verfique en la DB las conexiones", e);
			}
		}
	}
}
