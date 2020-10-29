package ar.com.educacionit.abm;

import ar.com.educacionit.clase4.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exceptions.ServiceException;

public class NuevoProductoMain {

	public static void main(String[] args) {
		
		String codigo = "001";
		String titulo = "Termo";
		Double precio = 1500d;
		Long tipoProducto = 1l;//celulares
		
		Producto productoAGrabar = new Producto(codigo, titulo, precio, tipoProducto);
		
		ProductoService productoService = new ProductoService();
		
		try {
			Producto productoGrabado = productoService.nuevoProducto(productoAGrabar);
			System.out.println("Producto Grabado: " + productoGrabado.getCodigo());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fin del programa");
	}

}
