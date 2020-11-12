package ar.com.educacionit.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapaEntryMain {

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

		//obtengo los entries del mapa
		Set<Entry<Integer, String>> entries = diasDeLaSemana.entrySet();
		
		//recorrer el mapa usando Entry
		for(Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + " "  + entry.getValue());
		}
	}

}
