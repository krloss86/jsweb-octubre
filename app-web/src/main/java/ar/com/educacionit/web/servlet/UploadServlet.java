package ar.com.educacionit.web.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.web.parsers.CSVFileParser;
import ar.com.educacionit.web.parsers.IFileParser;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1771151827580239286L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fileName = "c://desarrollo//clase12//texto.txt";
		
		int idx = fileName.lastIndexOf(".");
		String name = fileName.substring(0, idx);
		String type = fileName.substring(idx+1, fileName.length());
		
		IFileParser parser;
		
		if(type.equals("csv")) {
			parser = new CSVFileParser(type, fileName);
		}else if(type.equals("xls")) {
			parser = new CSVFileParser(type, fileName);
		} else {
			parser = new CSVFileParser(type, fileName);
		}
		
		Collection<Producto> productos = parser.parse();
		
		req.setAttribute("listado", productos);
		
		//redireccion a un listado
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp");
		
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String description = req.getParameter("description"); // Retrieves <input type="text" name="description">
	    Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    
	    int idx = fileName.lastIndexOf(".");
		String name = fileName.substring(0, idx);
		String type = fileName.substring(idx+1, fileName.length());
		
	    IFileParser parser;
		
		if(type.equals("csv")) {
			parser = new CSVFileParser(type, filePart);
		}else if(type.equals("xls")) {
			parser = new CSVFileParser(type, filePart);
		} else {
			parser = new CSVFileParser(type, filePart);
		}
		
		Collection<Producto> productos = parser.parse();
		
		req.setAttribute("listado", productos);//preview.jsp
		req.getSession().setAttribute("listado", productos);//CargarProductoServlet
		
		//redireccion a un listado
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/preview.jsp");
		
		rd.forward(req, resp);
	}
}
