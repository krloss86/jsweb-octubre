package ar.com.educacionit.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {

	public static void main(String[] args) {
		
		//creacion
		Set<Integer> edades = new TreeSet<Integer>();
		
		//agregar valores
		edades.add(10);
		edades.add(20);
		edades.add(10);
		edades.add(30);
		
		System.out.println("Tamaño:" + edades.size()); // ->3

		//eliminar
		edades.remove(10);
		
		System.out.println("Tamaño:" + edades.size()); // ->2
		
		System.out.println("Vacia ? " + edades.isEmpty());
		
		Iterator<Integer> itEdades = edades.iterator();
		while(itEdades.hasNext()) {
			itEdades.next();
			itEdades.remove();
		}
		
		System.out.println("Vacia ? " + edades.isEmpty());
	}

}
