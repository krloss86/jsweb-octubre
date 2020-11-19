package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.ProductoServiceImpl;
import ar.com.educacionit.service.exceptions.ServiceException;

@WebServlet("/NuevoProductoServlet")
public class NuevoProductoServlet extends HttpServlet {

	private static final long serialVersionUID = -3458677331446778026L;

	private ProductoService productoService = new ProductoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//tomar los parametros enviados desde el fomulario en nuevo.jsp
		
		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String precio = req.getParameter("precio");
		String tipoProducto = req.getParameter("tipoProducto");
		
		Float precioF = Float.parseFloat(precio);
		Long tipoProductoL = Long.parseLong(tipoProducto);
		
		Producto nuevoProducto = new Producto(codigo,titulo,precioF,tipoProductoL); 
		
		String target;
	
		try {
			this.productoService.nuevoProducto(nuevoProducto);
			
			Collection<Producto> listado = this.productoService.obtenerProductos();
			
			req.setAttribute("listado", listado);
			
			target = "/jsp/listado.jsp";
		} catch (ServiceException e) {
			
			req.setAttribute("listado", new ArrayList<>());
			
			req.setAttribute("error", e.getCause().getMessage());
			
			target = "/jsp/nuevo.jsp";
		}
		
		//redireccion
		RequestDispatcher rd =getServletContext().getRequestDispatcher(target);
		rd.forward(req, resp);
	}
}
