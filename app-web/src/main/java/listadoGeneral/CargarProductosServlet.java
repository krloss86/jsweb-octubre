package listadoGeneral;

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
import ar.com.educacionit.web.servlet.AppBaseServlet;

@WebServlet("/CargarProductosServlet")
public class CargarProductosServlet extends AppBaseServlet {

	private static final long serialVersionUID = -2741675821452652970L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Collection<Producto> productosEnSesion = (Collection<Producto>)req.getSession().getAttribute("listado");
				
		Collection<Producto> productosOK = new ArrayList<Producto>();
		Collection<Producto> productosFail = new ArrayList<Producto>();
		
		for(Producto producto : productosEnSesion) {
			try {
				productoService.nuevoProducto(producto);
				productosOK.add(producto);
			} catch (ServiceException e) {
				productosFail.add(producto);
			}
		}
		
		//request
		req.setAttribute("listadoOK", productosOK);
		
		//session
		req.getSession().setAttribute("listadoFail", productosFail);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listadoGeneral.jsp");
		
		rd.forward(req, resp);
	}

}
