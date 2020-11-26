package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		if(claveBuscadaPorUsuario == null) {
			claveBuscadaPorUsuario = "";
		}
		
		//filtros de busqueda
		String titulo = req.getParameter("titulo");
		String precio = req.getParameter("precio");
		String tipo = req.getParameter("tipoProducto");
		
		try {
			Collection<Producto> listado = this.productoService.buscarProductos(claveBuscadaPorUsuario);
			
			//aplico los filtros
			Stream<Producto> stream = listado.stream();
			if(titulo != null && !"".equals(titulo)) {
				stream = stream.filter(x-> x.getDescripcion().contains(titulo));
			}
			if(precio != null && !"".equals(precio)) {
				stream = stream.filter(x-> x.getPrecio().equals(Float.parseFloat(precio)));
			}
			if(tipo !=null && !"".equals(tipo)) {
				stream = stream.filter(x -> x.getTipoProducto().equals(Long.parseLong(tipo)));
			}
			
			List<Producto> listadoFiltrado  = stream.collect(Collectors.toList());
			//calculo la suma de los precios de los productos filtrados
			Float sumaTotal = listadoFiltrado.stream()
					.map(x-> x.getPrecio())
					.reduce(0F, (Float x, Float y) -> x + y);

			req.setAttribute("listado", listadoFiltrado);			
			req.setAttribute("claveBusqueda", claveBuscadaPorUsuario);			
			req.setAttribute("sumaTotal", sumaTotal);
			
		} catch (ServiceException e) {
			req.setAttribute("error", e.getMessage());
			req.setAttribute("listado", new ArrayList<>());
		}
		
		//redireccion al listado.jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp"); 
		rd.forward(req, resp);
	}
}
