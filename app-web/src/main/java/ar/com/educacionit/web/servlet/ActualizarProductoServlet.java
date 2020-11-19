package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ActualizarProductoServlet")
public class ActualizarProductoServlet extends AppBaseServlet {

	private static final long serialVersionUID = -3383254253978606780L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String precio = req.getParameter("precio");
		String tipoProducto = req.getParameter("tipoProducto");
		
		Long idL = Long.parseLong(id);
		Float precioF = Float.parseFloat(precio);
		Long tipoProductoL = Long.parseLong(tipoProducto);
		
		Producto producto = new Producto(idL,precioF,titulo,codigo,tipoProductoL);
		
		String target = "/jsp/listado.jsp";
		try {
			this.productoService.actualizarProducto(producto);
			
			req.setAttribute("exito", "Se ha actualizado el producto exitosamente");
			
			Collection<Producto> listado = this.productoService.obtenerProductos();
			
			req.setAttribute("listado", listado);
		} catch (ServiceException e) {
			req.setAttribute("error", e.getCause().getMessage());
			req.setAttribute("producto", producto);
			target = "/jsp/editar.jsp";
		} 
		
		//redireccion!
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.include(req, resp);
		
		//lineas codigo
	}
}
