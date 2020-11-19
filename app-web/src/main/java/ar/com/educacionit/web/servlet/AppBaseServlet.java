package ar.com.educacionit.web.servlet;

import javax.servlet.http.HttpServlet;

import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.ProductoServiceImpl;

public abstract class AppBaseServlet extends HttpServlet{

	private static final long serialVersionUID = -6285276310835215700L;
	
	protected ProductoService productoService  = new ProductoServiceImpl();
}
