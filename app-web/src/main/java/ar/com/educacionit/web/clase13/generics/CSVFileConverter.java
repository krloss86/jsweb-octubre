package ar.com.educacionit.web.clase13.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.domain.Producto;

public class CSVFileConverter implements FileConverter<List<String>> {

	private Collection<Producto> productos;
	
	public CSVFileConverter(Collection<Producto> productos) {
		this.productos = productos;
	}
	
	@Override
	public List<String> convert() {
		List<String> lineas = new ArrayList<String>();
		lineas.add("codigo;titulo;precio;tipo\n");

		for (Producto producto : productos) {
			StringBuffer linea = new StringBuffer();
			linea.append(producto.getCodigo()).append(";").append(producto.getDescripcion()).append(";")
					.append(producto.getPrecio()).append(";").append(producto.getTipoProducto()).append("\n");

			lineas.add(linea.toString());
		}

		return lineas;
	}
}
