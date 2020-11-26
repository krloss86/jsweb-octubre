package ar.com.educacionit.web.clase13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainLambda2 {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<Integer>();
		
		edades.add(25);		
		edades.add(35);		
		edades.add(40);		
		edades.add(21);
		
		System.err.println(edades);

		//convertir una coleccion a un set "edad : "25
		//map
		Set<String> edadesSetString = new HashSet<>();
		for(Integer edad : edades) {
			edadesSetString.add("edad: " + edad);
		}
		
		System.out.println(edadesSetString);
		
		//-------------------------------
		Stream<Integer> edadesStream = edades.stream();
		Stream<String> edadesStreamString = edadesStream.map( edad -> "edad: " + edad);
		Set<String> setString = edadesStreamString.collect(Collectors.toSet());
		System.out.println(setString);
	}

}
