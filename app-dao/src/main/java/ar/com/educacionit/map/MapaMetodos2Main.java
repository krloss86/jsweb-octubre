package ar.com.educacionit.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapaMetodos2Main {

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

		String lunes = diasDeLaSemana.remove(1);
		
		Map<Integer, String> dias2 = new HashMap<Integer, String>();
		dias2.put(10, lunes);
		
		//cargar un mapa en otro!
		
		diasDeLaSemana.putAll(dias2);
		
		System.out.println(diasDeLaSemana);
		
		//eliminar todos los valores de un mapa
		diasDeLaSemana.clear();
	}

}
