package ar.com.educacionit.queue;

import java.util.Collection;
import java.util.PriorityQueue;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class ProductosConPrioridad {

	public static void main(String[] args) throws GenericException {

		ProductoDAO productoDAO = new ProductoDAO();
		
		Collection<Producto> productos = productoDAO.findProductos();

		System.out.println("Productos desde db:" + productos);
		
		PriorityQueue<Producto> productosConPrioridad = new PriorityQueue<Producto>();
		
		productosConPrioridad.addAll(productos);
		
		while(!productosConPrioridad.isEmpty()) {
			System.out.print("Producto a tomar: " + productosConPrioridad.peek());
			
			Producto producto = productosConPrioridad.poll();
			
			System.out.println(producto);
			
			System.out.println("Restan: " + productosConPrioridad);
		}
		System.out.println("Productos con prioridad :" + productosConPrioridad);
	}

}
