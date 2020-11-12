package ar.com.educacionit.map;

import java.util.HashMap;
import java.util.Map;

public class DiasDeLaSemanaMain {

	public static void main(String[] args) {
		
		//clase9 ->mapas
		
		//interfaz i = new Clase()
		//creacion
		Map<Integer, String> diasDeLaSemana = new HashMap<>(); 

		//carga
		diasDeLaSemana.put(1, "Lunes");
		diasDeLaSemana.put(2, "Martes");
		diasDeLaSemana.put(3, "Miercoles");
		diasDeLaSemana.put(4, "Jueves");
		diasDeLaSemana.put(5, "Viernes");
		diasDeLaSemana.put(6, "Sabado");
		diasDeLaSemana.put(7, "Domingo");
		
		//obtener los valores de un mapa
		Integer dia = 6;
		String valor;
		
		valor = diasDeLaSemana.get(dia);
		System.out.println("Dia: " + dia + " - "+ valor);
	}

}
