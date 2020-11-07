package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionMain {

	public static void main(String[] args) {

		//crear una collection de Integer		
		//clase concreta
		List<Integer> edades = new ArrayList<>();
		
		//uso de la arraylist
		edades.add(25);
		edades.add(28);
		edades.add(28);
		edades.add(30);
		
		//tamaño de la coleccion
		System.out.println("Tamaño:" + edades.size());
		System.out.println("Vacia:" + edades.isEmpty());
		
		int indexOf28 = edades.indexOf(28);
		System.out.println("El elemento 28 está en la posicion: " + indexOf28);
		
		int lasIndexOf28 = edades.lastIndexOf(28);
		System.out.println("El elemento 28 está en la posicion: " + lasIndexOf28);
		
		//igualdad
		List<Integer> otrasEdades = new ArrayList<Integer>();
		
		otrasEdades.add(25);
		otrasEdades.add(28);
		otrasEdades.add(28);
		otrasEdades.add(30);
		
		boolean iguales = edades.equals(otrasEdades);
		System.out.println("Iguales ? " + iguales);
		
		
		//recorrer
		//for
		for(Integer edad : edades) {
			System.out.println("Edad es:" + edad);
		}
		
		//obtener un valor
		Integer edad30 = edades.get(2);
		System.out.println("Edad en la posicion 2 es:" + edad30);
		
		//recorrer agregando y usando indice
		for(int i=0; i < edades.size();i++) {
			Integer edad = edades.get(i);
			System.out.println("Edad es:" + edad);
			//edades.add(edad+10);
			
			//OJO CON ESTO!!!
		}
		
		//recorrer con Iterator
		Iterator<Integer> itEdades = edades.iterator();
		while(itEdades.hasNext()) {
			Integer edad = itEdades.next();
			
			//edades.add(35);// OJO CON ESTO, DA ERROR RUNTIME
			
			System.out.println("Edad : " + edad);
		}
		
		//ELIMINAR ELEMENTOS
		//da error con for
		/*for(Integer edad : edades ) {
			edades.remove(edad);
		}*/
		
		//correcta de eliminar/vaciar la coleccion
		System.out.println("Edades en la coleccion: " + edades);
		Iterator<Integer> Itedades = edades.iterator();
		while(Itedades.hasNext()) {
			Integer edad = Itedades.next();
			System.out.println("Edad a eliminar : " +edad);
			Itedades.remove();
			System.out.println("Edades en la coleccion: " + edades);
		}
	}

}
