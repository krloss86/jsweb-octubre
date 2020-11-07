package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Menu;

public class MenuDAO {

	public Collection<Menu> findMenu()  throws GenericException{
		
		Collection<Menu> menus = new ArrayList<>();
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		String  sql = "SELECT codigo, descripcion FROM menu order by codigo asc";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}

		try {
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
								
				resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					Menu menu = new Menu(resultSet.getInt(1), resultSet.getString(2));
					menus.add(menu);
				}
			}

			return menus;
			
		} catch (SQLException e) {
			throw new GenericException("No se han podido obtener la lista de menu", e);
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
