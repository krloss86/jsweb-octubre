package ar.com.educacionit.web.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;

@WebServlet("/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends AppBaseServlet {

	private static final long serialVersionUID = 8826701655522279651L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String formatoSalida = req.getParameter("formato");// ->XLS o CSV ->mail

		String filename = "listado-producto-error";

		String filePathOutput = "c:" + File.separator + "desarrollo" + File.separator + "clase12" + File.separator
				+ filename + "." + formatoSalida;

		File outputFile = new File(filePathOutput);

		if (!outputFile.exists()) {
			// creamo
			Files.createFile(outputFile.toPath());
		}

		FileWriter fr = new FileWriter(outputFile);

		// bajar de la sesion los productos con errores
		Collection<Producto> productosEnSesion = (Collection<Producto>) req.getSession().getAttribute("listado");
		List<String> lineasDelArchivoDeSalida = convertir(productosEnSesion);

		for (String linea : lineasDelArchivoDeSalida) {
			fr.write(linea);
		}

		fr.close();

		// logica para descargar el file

		resp.setContentType("text/csv");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "." + formatoSalida + "\" ");
		// escribir el contenido en el response
		try {
			OutputStream outputStream = resp.getOutputStream();

			byte[] byteDelArchivoGenerado = Files.readAllBytes(outputFile.toPath());
			outputStream.write(byteDelArchivoGenerado);

			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			resp.getWriter().print("No se ha podido generar el archivo, por favor reintente");
		}
	}

	public List<String> convertir(Collection<Producto> productos) {

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
