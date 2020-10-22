package ar.com.educacionit.app.domain.clases.clase3;

public class CastingMain {

	public static void main(String[] args) {
		
		//byte < short < int < long < float < double
		byte edad = 127;
		
		int edadInt = edad;
		
		float edadFloat = 127.5f;
		
		edadInt = (int)edadFloat;//127
	}

}
