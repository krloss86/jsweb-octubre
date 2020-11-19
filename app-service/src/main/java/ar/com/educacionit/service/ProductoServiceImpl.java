package ar.com.educacionit.service;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.exceptions.NonExistsExeption;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exceptions.ServiceException;

public class ProductoServiceImpl implements ProductoService {

	//atributo de instancia
	private ProductoDAO productoDao = new ProductoDAO();
	
	public Producto nuevoProducto(Producto productoAGrabar) throws ServiceException {
		
		try {
			return productoDao.insert(productoAGrabar);
		} catch (DuplicatedException | GenericException e) {
			throw new ServiceException("No se ha podido grabar el producto.", e);
		}
	}
	
	@Override
	public Collection<Producto> buscarProductos(String clave) throws ServiceException {
		try {
			return this.productoDao.buscar(clave);
		} catch (GenericException e) {
			throw new ServiceException("Error interno, no se ha podido obtener el listado", e);			
		}
	}

	@Override
	public Collection<Producto> obtenerProductos() throws ServiceException {		
		try {
			return this.productoDao.findProductos();
		} catch (GenericException e) {
			throw new ServiceException("Error interno, por favor reintente", e);
		}
	}

	@Override
	public void eliminarProducto(Long id) throws ServiceException {
		try {
			this.productoDao.delete(id);
		} catch (NonExistsExeption e) {
			throw new ServiceException("No existe el producto con id: "+ id, e);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido eliminar el producto id: "+id+", error inesperado", e);
		}
	}

	@Override
	public Producto obtenerProductoById(Long id) throws ServiceException {
		try {
			return this.productoDao.getById(id);
		} catch (GenericException e) {
			throw new ServiceException("Error de servicio, consultando producto", e);
		}
	}

	@Override
	public void actualizarProducto(Producto producto) throws ServiceException {
		try {
			this.productoDao.update(producto);
		} catch (NonExistsExeption | GenericException e) {
			throw new ServiceException("Error interno, no se ha podido actualizar el producto, por favor reintente", e);
		}
	}
}
