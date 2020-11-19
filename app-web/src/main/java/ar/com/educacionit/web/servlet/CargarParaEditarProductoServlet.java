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

@WebServlet("/CargarParaEditarProductoServlet")
public class CargarParaEditarProductoServlet extends AppBaseServlet {

	private static final long serialVersionUID = -2546577250200039813L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		
		String target = "/jsp/listado.jsp";
		
		try {
			Producto producto = this.productoService.obtenerProductoById(Long.parseLong(id));
			
			//guardo el producto en el request, para mostrarlo en editar.jsp
			
			req.setAttribute("producto", producto);
			
			target = "/jsp/editar.jsp";
		} catch (NumberFormatException e) {
			req.setAttribute("error", "ID "+id+" inválido");
		} catch (ServiceException e) {
			req.setAttribute("error", e.getCause().getMessage());
		} finally {
			Collection<Producto> listado;
			try {
				listado = productoService.obtenerProductos();
			} catch (ServiceException e1) {
				listado = new ArrayList<Producto>();	
			}
			req.setAttribute("listado", listado);
		}
		
		//redireccion! 
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(req, resp);
	}
}

