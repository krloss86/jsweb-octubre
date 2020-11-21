package ar.com.educacionit.web.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.Part;

import ar.com.educacionit.domain.Producto;

public class CSVFileParser extends FileParserBase implements IFileParser {

	public CSVFileParser(String type, String name) {
		super(type, name);
	}

	public CSVFileParser(String type, Part filePart) {
		super(type, filePart);
	}

	@Override
	public Collection<Producto> parse() throws IOException {
		
		BufferedReader br = null;
		
		if(super.filePart != null) {
			InputStream fileContent = filePart.getInputStream();
		    br = new BufferedReader(new InputStreamReader(fileContent));
		}else {
		
			File file = new File(super.name);
			
			if(file.exists()) {
				
				FileReader fr = new FileReader(file);
				
				br = new BufferedReader(fr);
			}
		}
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		if(br != null) {
			productos = buildProductos(br);
		}
		
		return productos;
	}

	private Collection<Producto> buildProductos(BufferedReader br) throws IOException {
		
		Collection<Producto> productos = new ArrayList<Producto>(); 
		
		String lineaLeida;
		
		//primer lecturta
		lineaLeida = br.readLine();
		
		//evalua
		while(lineaLeida != null) {
			
			//vuelvo a leer otra linea mas
			lineaLeida = br.readLine();
			
			if(lineaLeida != null ) {
				
				String[] split = lineaLeida.split(";");
				
				if(split.length > 1 && !"".equals(split[0]) ) {
					//parseo
					String codigo = split[0];					
					String titulo = split[1];
					Float precio = Float.parseFloat(split[2]);
					Long tipoProducto = Long.parseLong(split[3]);
					
					productos.add(new Producto(codigo, titulo, precio, tipoProducto));
				}
			}
		}
		
		//cerrar buffer
		br.close();
		
		return productos;
	}

}
