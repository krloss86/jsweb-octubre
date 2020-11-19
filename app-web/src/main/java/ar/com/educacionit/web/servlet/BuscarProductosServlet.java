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

@WebServlet("/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {

	private static final long serialVersionUID = 5622320080975074322L;

	//agregamos la insterfaz ProductoService
	private ProductoService productoService  = new ProductoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String claveBuscadaPorUsuario = req.getParameter("claveBusqueda");
		
		//validaciones
		//hw
		
		try {
			Collection<Producto> listado = this.productoService.buscarProductos(claveBuscadaPorUsuario);
			req.setAttribute("listado", listado);
		} catch (ServiceException e) {
			req.setAttribute("error", e.getMessage());
			req.setAttribute("listado", new ArrayList<>());
		}
		
		//redireccion al listado.jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp"); 
		rd.forward(req, resp);
	}
}
