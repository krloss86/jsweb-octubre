package ar.com.educacionit.app.domain;

public class VectorMain {

	public static void main(String[] args) {
		
		//vector con valores
		byte[] edades = {37,18,34,31};
				
		for(int i = edades.length-1 ;i >= 0; i--) {
			byte edad = edades[i]; 
			System.out.println(edad);
		}

		//otro vector
		byte[] edades2 = new byte[4];
		edades2[0] = 37;
		edades2[1] = 18;
		edades2[2] = 34;
		edades2[3] = 31;
		
		for(byte edad : edades2) {
			System.err.println(edad);
		}
	} 

}
