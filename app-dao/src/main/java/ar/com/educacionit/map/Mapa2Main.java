package ar.com.educacionit.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapa2Main {

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

		//obtener las claves del mapa
		Set<Integer> claves = diasDeLaSemana.keySet();
		
		System.out.println("Las claves son:"  + claves.toString());
		
		//obtener los valores del mapa
		Collection<String> valores = diasDeLaSemana.values();
		System.out.println("Los valores son:"  + valores.toString());
		
		//recorrer cada clave e ir obteniendo el valor asociado
		for(Integer key : claves) {
			String value = diasDeLaSemana.get(key);
			System.out.println(key + " - " + value);
		}
	}

}
