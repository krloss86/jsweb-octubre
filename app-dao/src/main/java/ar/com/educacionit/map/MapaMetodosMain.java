package ar.com.educacionit.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapaMetodosMain {

	public static void main(String[] args) {
		Map<Integer, String> diasDeLaSemana = new HashMap<>(); 

		//carga
		diasDeLaSemana.put(1, "Lunes");
		diasDeLaSemana.put(2, "Martes");
		diasDeLaSemana.put(3, "Miercoles");
		diasDeLaSemana.put(4, "Jueves");
		diasDeLaSemana.put(5, "Viernes");
		diasDeLaSemana.put(6, "Sabado");
		diasDeLaSemana.put(7, "Domingo");

		//existe un valor?
		boolean contieneAL9 = diasDeLaSemana.containsKey(9);
		System.out.println("Contiene al 9?" + contieneAL9);
		
		boolean contieneDomingo = diasDeLaSemana.containsValue("Domingo");
		System.out.println("Contiene al Domingo" + contieneDomingo);
		
		//mapa vacio?
		boolean isMapaVacio = diasDeLaSemana.isEmpty();
		System.out.println("Mapa Vacio?" + isMapaVacio);
		
		//eliminar valor del mapa
		String diaEliminado = diasDeLaSemana.remove(1);
		System.out.println(diasDeLaSemana);
		System.err.println(diaEliminado);
		
		//actualizar
		diasDeLaSemana.put(8, "Osvaldo");
		System.out.println(diasDeLaSemana);
		
		//igualdad
		System.out.println("igual a si mismo" + diasDeLaSemana.equals(diasDeLaSemana));
	}

}
