package ar.com.educacionit.web.clase13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainLambda4 {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<Integer>();		
		edades.add(25);		
		edades.add(35);		
		edades.add(40);
		edades.add(30);	
		edades.add(21);		
		
		//edad > 21
		Integer edadFiltro = 40;
		boolean existe = false;
		for(Integer edad : edades) {
			//filtro
			if(edad == edadFiltro) {
				existe = true;
				break;
			}
		}		

		boolean existe2 = edades.stream().anyMatch(x-> x == 40);
		
		System.err.println(existe);
		System.err.println(existe2);
	}

}
