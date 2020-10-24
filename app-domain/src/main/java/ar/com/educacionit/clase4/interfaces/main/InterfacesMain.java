package ar.com.educacionit.clase4.interfaces.main;

import ar.com.educacionit.clase4.interfaces.ICantante;
import ar.com.educacionit.clase4.interfaces.Mamifero;
import ar.com.educacionit.clase4.interfaces.Persona;

public class InterfacesMain {

	public static void main(String[] args) {
		
		Mamifero persona = new Persona("carlos");
		
		persona.hablar();
		
		Persona personaEnMamifero = (Persona)persona;
		
		personaEnMamifero.hablar();
		
		personaEnMamifero.cantar();
		
		ICantante personaCantante = (ICantante)personaEnMamifero;
		
		
	}
}
