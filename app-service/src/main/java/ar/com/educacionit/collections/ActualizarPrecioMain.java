package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.exceptions.NonExistsExeption;
import ar.com.educacionit.domain.Producto;

public class ActualizarPrecioMain {

	public static void main(String[] args) throws GenericException, NonExistsExeption {
		
		ProductoDAO productoDao = new ProductoDAO();
		
		Collection<Producto> productos = productoDao.findProductos();

		List<Producto> productosAModificar = new ArrayList<Producto>();
		
		//si precio < 20000 => 10%
		for(Producto producto : productos) {
			if(producto.getPrecio() < 20000f) {
				productosAModificar.add(producto);
			}
		}
		
		//si existen productos => update
		if(!productosAModificar.isEmpty()) {
			for(Producto producto : productosAModificar) {
				producto.setPrecio(producto.getPrecio() * 1.1f);
				
				//actualziar
				productoDao.update(producto);
			}
		}
	}

}
