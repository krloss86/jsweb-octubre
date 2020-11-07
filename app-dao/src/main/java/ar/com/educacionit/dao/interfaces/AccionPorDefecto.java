package ar.com.educacionit.dao.interfaces;

public class AccionPorDefecto implements IAccion {
	
	@Override
	public void ejecutar() {
		System.err.println("Accion de fecto, no ejecuta lógica de negocio");
	}

}
