package ar.com.educacionit.service;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exceptions.ServiceException;

public class ProductoService {

	public Producto nuevoProducto(Producto productoAGrabar) throws ServiceException {
		
		ProductoDAO productoDao = new ProductoDAO();
		
		try {
			return productoDao.insert(productoAGrabar);
		} catch (DuplicatedException | GenericException e) {
			throw new ServiceException("No se ha podido grabar el producto.", e);
		}
	}
}
