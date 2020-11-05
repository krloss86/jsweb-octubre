package ar.com.educacionit.dao.builder;

import ar.com.educacionit.dao.interfaces.ActualizarProducto;
import ar.com.educacionit.dao.interfaces.ConsultaPorCodigo;
import ar.com.educacionit.dao.interfaces.ConsultaPorID;
import ar.com.educacionit.dao.interfaces.ConsultaPorTitulo;
import ar.com.educacionit.dao.interfaces.ConsultarTodos;
import ar.com.educacionit.dao.interfaces.CrearProducto;
import ar.com.educacionit.dao.interfaces.EliminarProducto;
import ar.com.educacionit.dao.interfaces.IAccion;

public class ProductoAccionBuilder {

	//metodo de clase
	public static IAccion buildAccion(Integer opcion) {
		IAccion accion;
		
		switch (opcion) {
			case 1:
				accion = new CrearProducto();
				break;
			case 2:
				accion = new ConsultaPorCodigo();
				break;
			case 3:
				accion = new ConsultarTodos();
				break;
			case 4:
				accion = new EliminarProducto();
				break;
			case 5:
				accion = new ActualizarProducto();
				break;
			case 6:
				accion = new ConsultaPorID();
				break;
			case 7:
				accion = new ConsultaPorTitulo();
				break;
			default:
				accion = null;
				break;
		}
		
		if(accion == null ) {
			throw new RuntimeException("Opción "+opcion+" Inválida");
		}
		
		return accion;
	}
	
}
