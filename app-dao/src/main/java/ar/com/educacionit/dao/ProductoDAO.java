package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import ar.com.educacionit.clase4.Producto;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;

public class ProductoDAO {

	public Producto insert(Producto producto) throws DuplicatedException, GenericException {
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		//sql grabar productos
		
		String  sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) VALUES ('"+producto.getDescripcion()+"', '"+producto.getPrecio()+"', '"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"');";
		
		Statement statement;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}
		
		try {
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				Long idGeneradoEnLaDB = resultSet.getLong(1);
				
				producto.setId(idGeneradoEnLaDB);
			}
			
			return producto;
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new DuplicatedException("No se ha podido crear el producto", e);
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el producto", e);
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("NO se pudo cerrar la conexion, verfique en la DB las conexiones", e);
			}
		}
	}
	
	public Producto getByCodigo(String codigo) throws GenericException {
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		//sql grabar productos
		
		String  sql = "SELECT * FROM productos WHERE CODIGO = '"+codigo+"'";
		
		Statement statement;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}
		
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			Producto producto = null;
			if(resultSet.next()) {
				producto = productoDesdeResultSet(resultSet);
			}

			return producto;
			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto, codigo:"+codigo, e);
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("NO se pudo cerrar la conexion, verfique en la DB las conexiones", e);
			}
		}
	}

	private Producto productoDesdeResultSet(ResultSet resultSet) throws SQLException {
		Producto producto;
		Long id = resultSet.getLong(1);
		String titulo = resultSet.getString(2);
		Float precio = resultSet.getFloat(3);
		String codigoDB = resultSet.getString(4);
		Long tipoProducto = resultSet.getLong(5); 
		
		producto = new Producto(id, precio, titulo, codigoDB, tipoProducto);
		return producto;
	}
	
	public Producto[] findProductos()  throws GenericException{
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		//saber cuantos hay
		String  sql = "SELECT count(*) FROM productos";
		
		Statement statement;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}

		try {
			ResultSet resultSet = statement.executeQuery(sql);
			
			Producto[] productos = null;
			
			if(resultSet.next()) {
				
				Long cantidad = resultSet.getLong(1);
				int i = 0;
				productos = new Producto[cantidad.intValue()];
				
				sql = "SELECT * FROM productos";
				
				resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
					Producto producto = productoDesdeResultSet(resultSet);
					productos[i++] = producto;
				}
			}

			return productos;
			
		} catch (SQLException e) {
			throw new GenericException("No se han podido obtener lso productos", e);
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
