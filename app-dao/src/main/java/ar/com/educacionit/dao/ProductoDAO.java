package ar.com.educacionit.dao;

import ar.com.educacionit.clase4.Producto;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;

public class ProductoDAO {

	public Producto insert(Producto producto) throws DuplicatedException, GenericException {
		
		Connection connection = AdminstradorDeConexiones.obtenerConexion();
		
		//sql grabar productos
		
		Producto productoNuevo = producto;
		producto.setId((int)Math.random());
		
		if(true) {
			throw new DuplicatedException("PK duplicada" + producto.getCodigo());
		}
		return productoNuevo;
	}
}
