package ar.com.educacionit.web.clase13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainLambda3 {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<Integer>();		
		edades.add(25);		
		edades.add(35);		
		edades.add(40);
		edades.add(30);	
		edades.add(21);		
		//edad > 21
		Collection<Integer> edadesFiltradas = new ArrayList<Integer>();
		Integer edadFiltro = 21;
		for(Integer edad : edades) {
			//filtro
			if(edad > edadFiltro) {
				//recolecto los datos que cumplen el filtro
				edadesFiltradas.add(edad);				
			}
		}		
		List<Integer> edadesPares = new ArrayList<Integer>();
		int resto = 0;
		for(Integer edadPar : edadesFiltradas) {
			if(edadPar % 2 == resto) {
				edadesPares.add(edadPar);
			}
		}		
		//acá sumo: funcion terminal
		Integer suma = 0;//70
		for(Integer edadPar : edadesPares) {
			suma = suma + edadPar;
		}		
		System.err.println(suma);
		//---------------------------------
		//api fluid
		Integer suma2 = edades.stream()
			.filter(x -> x > 21)
			.filter(x -> x %2 == 0)
			.reduce(0, Integer::sum);// "method reference"
		System.out.println(suma2);
	}

}
