package ar.com.educacionit.map;

import java.util.HashMap;
import java.util.Map;

import ar.com.educacionit.dao.builder.ProductoAccionBuilder;
import ar.com.educacionit.dao.interfaces.IAccion;

public class MapaConInterfaz {

	public static void main(String[] args) {
		
		Map<Integer,IAccion> mapaAcciones = new HashMap<>();
		
		IAccion accion = ProductoAccionBuilder.buildAccion(1);
		
		accion.ejecutar();
	}
}
