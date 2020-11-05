package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.exceptions.NonExistsExeption;
import ar.com.educacionit.domain.Producto;

public class ProductoDAO {

	public Producto insert(Producto producto) throws DuplicatedException, GenericException {
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		boolean hasError = false;
		
		try {
			connection.setAutoCommit(false);
			
			//sql grabar productos
												// string   float	string 	long	             1  2  3  4
			String  sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) VALUES (? , ? , ? , ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			//seteo EN ORDEN los parametros asociados
			statement.setString(1, producto.getDescripcion());
			statement.setFloat(2, producto.getPrecio());
			statement.setString(3, producto.getCodigo());
			statement.setLong(4, producto.getTipoProducto());
			
			statement.execute();
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				Long idGeneradoEnLaDB = resultSet.getLong(1);
				
				producto.setId(idGeneradoEnLaDB);
			}
			
			connection.commit();
			
			return producto;			
		} catch (SQLException e) {
			hasError = true;
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new GenericException("No se ha podido crear el producto, producto duplicado", e);	
			}
			throw new GenericException("No se ha podido crear el producto", e);
		} 
		finally {
			try {
				if(hasError) {
					connection.rollback();
				}else {
					connection.commit();				
				}
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
	
	/**
	 * Obtiene un producto dado su PK
	 * @param codigo
	 * @return
	 * @throws GenericException
	 */
	public Producto getById(Long id) throws GenericException {
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		//sql grabar productos
		
		String  sql = "SELECT * FROM productos WHERE id = '"+id+"'";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}
		
		try {
			ResultSet resultSet = statement.executeQuery();
			Producto producto = null;
			if(resultSet.next()) {
				producto = productoDesdeResultSet(resultSet);
			}

			return producto;
			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto, id:"+id, e);
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
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}

		try {
			ResultSet resultSet = statement.executeQuery();
			
			Producto[] productos = null;
			
			if(resultSet.next()) {
				
				Long cantidad = resultSet.getLong(1);
				int i = 0;
				productos = new Producto[cantidad.intValue()];
				
				sql = "SELECT * FROM productos";
				statement = connection.prepareStatement(sql);
				
				resultSet = statement.executeQuery();
				
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
	
	public Producto delete(Long id) throws NonExistsExeption, GenericException {
		
		Producto producto = this.getById(id);
		if(producto == null) {
			throw new NonExistsExeption("No se ha encontrado el producto con id:" + id);
		}
		
		String sql = "delete from productos where id = ?";
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}
		
		try {
			int resultado = statement.executeUpdate();
			if(resultado < 0) {
				throw new GenericException("No se ha podido eliminar el producto id:" + id);
			}			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido eliminar el producto id:" + id, e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("NO se pudo cerrar la conexion, verfique en la DB las conexiones", e);
			}
		}
		
		return producto;
	}
	
	public Producto update(Producto producto) throws NonExistsExeption, GenericException {
		
		Producto productoAux = this.getById(producto.getId());
		if(productoAux == null) {
			throw new NonExistsExeption("No se ha encontrado el producto con id:" + producto.getId());
		}
		
		String sql = "UPDATE productos SET titulo = ? , precio = ? , tipo_producto = ? WHERE  id = ?";
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, producto.getDescripcion());
			statement.setFloat(2, producto.getPrecio());
			statement.setLong(3, producto.getTipoProducto());
			statement.setLong(4, producto.getId());
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el Statement", e);
		}
		
		try {
			int resultado = statement.executeUpdate();
			if(resultado < 0) {
				throw new GenericException("No se ha podido eliminar el producto id:" + producto.getId());
			}			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido eliminar el producto id:" + producto.getId(), e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("NO se pudo cerrar la conexion, verfique en la DB las conexiones", e);
			}
		}
		
		return producto;
	}
	
	public Producto[] search(String titulo) throws GenericException {
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		//saber cuantos hay
		String  sql = "SELECT count(*) FROM productos where upper(titulo) like '% ? %'";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, titulo);
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
				
				sql ="SELECT * FROM productos where upper(titulo) like '% ? %'";
				
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, titulo);
				
				resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
					Producto producto = productoDesdeResultSet(resultSet);
					productos[i++] = producto;
				}
			}

			return productos;
			
		} catch (SQLException e) {
			throw new GenericException("No se han podido obtener los productos", e);
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
