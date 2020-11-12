package ar.com.educacionit.dao.builder;

import java.util.HashMap;
import java.util.Map;

import ar.com.educacionit.dao.interfaces.AccionPorDefecto;
import ar.com.educacionit.dao.interfaces.ActualizarPrecio;
import ar.com.educacionit.dao.interfaces.ActualizarProducto;
import ar.com.educacionit.dao.interfaces.ConsultaPorCodigo;
import ar.com.educacionit.dao.interfaces.ConsultaPorID;
import ar.com.educacionit.dao.interfaces.ConsultaPorTitulo;
import ar.com.educacionit.dao.interfaces.ConsultarTodos;
import ar.com.educacionit.dao.interfaces.CrearProducto;
import ar.com.educacionit.dao.interfaces.EliminarProducto;
import ar.com.educacionit.dao.interfaces.IAccion;

public class ProductoAccionBuilder {

	static Map<Integer, IAccion> mapaAcciones = buildAcciones();
			
	//metodo de clase
	public static IAccion buildAccion(Integer opcion) {
		
		IAccion accion = mapaAcciones.get(opcion);				
		
		if(accion == null) {
			accion = new AccionPorDefecto();
		}
		
		return accion;
	}

	private static Map<Integer, IAccion> buildAcciones() {
		
		Map<Integer, IAccion> acciones = new HashMap<Integer, IAccion>();
		//carega el mapa
		acciones.put(1, new CrearProducto());
		acciones.put(2, new ConsultaPorCodigo());
		acciones.put(3, new ConsultarTodos());
		acciones.put(4, new EliminarProducto());
		acciones.put(5, new ActualizarProducto());
		acciones.put(6, new ConsultaPorID());
		acciones.put(7, new ConsultaPorTitulo());
		acciones.put(8, new ActualizarPrecio());
				
		return acciones;
	}
	
}
