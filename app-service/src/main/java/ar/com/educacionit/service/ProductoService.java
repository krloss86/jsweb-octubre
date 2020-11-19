package ar.com.educacionit.service;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exceptions.ServiceException;

public interface ProductoService {

	public Producto nuevoProducto(Producto productoAGrabar) throws ServiceException;

	public Collection<Producto> buscarProductos(String clave) throws ServiceException;

	public Collection<Producto> obtenerProductos() throws ServiceException;

	public void eliminarProducto(Long id) throws ServiceException;

	public Producto obtenerProductoById(Long id) throws ServiceException;

	public void actualizarProducto(Producto producto) throws ServiceException;
	
}
