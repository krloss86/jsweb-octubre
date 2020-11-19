package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exceptions.ServiceException;

@WebServlet("/EliminarProductoServlet")
public class EliminarProductoServlet extends AppBaseServlet {

	private static final long serialVersionUID = -7269953341819877637L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		//validacion 
		if(id == null || id.trim().equals("")) {
			//redireccion por medio de Response
			resp.sendRedirect(req.getContextPath()+ "/jsp/listado");
		}
		
		Long idL = Long.parseLong(id);
		
		try {
			this.productoService.eliminarProducto(idL);
			
			req.setAttribute("exito", "Se ha eliminado el producto id:" + id);
			
		} catch (ServiceException e) {
			
			req.setAttribute("error", e.getCause().getMessage());
		}
		
		try {
			Collection<Producto> listado = this.productoService.obtenerProductos();
			req.setAttribute("listado", listado);
		} catch (ServiceException e) {
			req.setAttribute("error", e.getMessage());			
			req.setAttribute("listado", new ArrayList<>());
		}
		
		//redireccion
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp");
		rd.forward(req, resp);
	}
}
