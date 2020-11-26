package ar.com.educacionit.web.clase13.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.ProductoServiceImpl;
import ar.com.educacionit.service.exceptions.ServiceException;

public class MainGeneric {

	public static void main(String[] args) throws ServiceException {
		
		ProductoService ps = new ProductoServiceImpl();
		Collection<Producto> productos = ps.obtenerProductos();
	
		List<FileConverter> tipos = new ArrayList<FileConverter>();
		
		tipos.add(new CSVFileConverter(productos));
		tipos.add(new XLSFileConverter(productos));
	
		tipos.stream()
			.peek(x-> System.out.println(x.convert()))
			.collect(Collectors.toSet());
	}

}
