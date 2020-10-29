package ar.com.educacionit.clase5;

import ar.com.educacionit.app.domain.clases.Buscador;

public class BuscadorExceptionMain {

	public static void main(String[] args) {
		
		Buscador buscador = new Buscador();
		
		try {
			buscador.buscar();
		} catch (BuscadorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(buscador.getCantResult());

	}

}
