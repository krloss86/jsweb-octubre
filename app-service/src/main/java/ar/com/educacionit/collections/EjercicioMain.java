package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class EjercicioMain {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<>();
		
		edades.add(25);
		edades.add(28);
		edades.add(28);
		edades.add(30);
		
		System.out.println("Edades :" + edades);
		
		edades = new HashSet<Integer>(edades);
		
		System.out.println("Edades No Dupl:" + edades);
	}

}
