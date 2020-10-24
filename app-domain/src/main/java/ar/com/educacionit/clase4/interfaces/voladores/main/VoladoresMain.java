package ar.com.educacionit.clase4.interfaces.voladores.main;

import ar.com.educacionit.clase4.interfaces.voladores.Aterrizable;
import ar.com.educacionit.clase4.interfaces.voladores.Avion;
import ar.com.educacionit.clase4.interfaces.voladores.Helicopetero;
import ar.com.educacionit.clase4.interfaces.voladores.Ovni;
import ar.com.educacionit.clase4.interfaces.voladores.SuperMan;
import ar.com.educacionit.clase4.interfaces.voladores.Volador;

public class VoladoresMain {

	public static void main(String[] args) {
		
		//crear el vector de los voladores
		
		Volador[] voladores = new Volador[4];

		Avion avion = new Avion("BOEING 747");		
		voladores[0] = avion;
		
		Helicopetero helicopetero = new Helicopetero("BOEING AH-64 APACHE");		
		voladores[1] = helicopetero;
		
		Ovni ovni = new Ovni("DESCONOCIDO");		
		voladores[2] = ovni;		
		
		SuperMan superman = new SuperMan();		
		voladores[3] = superman;
		
		//recorrer el vector		
		for(int i = 0; i < voladores.length; i++  ) {
			
			Volador aux = voladores[i];
			
			//¿puede aterrizar?
			if(aux instanceof Aterrizable) {
				
				//polimorfismo
				Aterrizable atr = (Aterrizable)aux;
				
				atr.aterrizar();
				
				if(aux.tieneTurbina()) {
					
					System.out.println("Pista1");
				}else {
					
					System.out.println("Pista2");
				}
			}else {
				if(aux instanceof Ovni) {
					
					Ovni auxOvni = (Ovni)aux;
					auxOvni.aterrizar();
				}
			}
		}
	}

}
