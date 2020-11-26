package ar.com.educacionit.web.clase13.generics;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.ProductoServiceImpl;
import ar.com.educacionit.service.exceptions.ServiceException;

public class MainGeneric1 {

	public static void main(String[] args) throws ServiceException {
		
		ProductoService ps = new ProductoServiceImpl();
		Collection<Producto> productos = ps.obtenerProductos();
	
		//FILTRO PRODUCTOS CON PRECIO > 10000
		List<Producto> filtrados = productos.stream()
		.filter( x -> x.getTipoProducto().equals(2L))
		.filter( (Producto x) -> x.getPrecio() > 1000 )
		.filter(x -> x.getDescripcion().contains("teclado"))
		.collect(Collectors.toList());
		
		System.err.println(filtrados);
	}

}
