package ar.com.educacionit.app.domain.clases.clase3;

public class ClaseBaseMain {

	//main
	//ctrl+space+enter
	public static void main(String[] args) {
		
		Clase1 clase1 = new Clase1("ivana", 25);
		
		ClaseBase clasebase = new ClaseBase("carlo", 34);
		
		//esto da error! 
		ClaseBase aux = (Clase1)clasebase;
	}
}
