package ar.com.educacionit.web.clase13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainLambda {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<Integer>();
		
		edades.add(25);		
		edades.add(35);		
		edades.add(40);		
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
		
		//finalmente : una funciona terminal de recoleccion. 
		System.out.println(edadesPares);
		
		
		//de la coleccion contruyo el stream
		Stream<Integer> edadesStreams = edades.stream();
		
		//aplicar funciones intermedias
		Stream<Integer> edadesStream21 = edadesStreams.filter( pepe -> pepe > edadFiltro );
		Stream<Integer> edadesStreamPares = edadesStream21.filter( x -> x %2 == resto);
		List<Integer> edadesStreamFiltradas =  edadesStreamPares.collect(Collectors.toList());
		System.out.println(edadesStreamFiltradas);
	}
}
