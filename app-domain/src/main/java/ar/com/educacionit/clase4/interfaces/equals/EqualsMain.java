package ar.com.educacionit.clase4.interfaces.equals;

import ar.com.educacionit.clase4.Producto;

public class EqualsMain {

	public static void main(String[] args) {
		
		Producto p1 = new Producto(1L, 1500f, "termo lumilagro");		
		Producto p2 = new Producto(1L, 1500f, "termo lumilagro");
		
		if(p1 == p2) {
			System.out.println("Son el mismo objetos");
		}else {
			System.out.println("Son distintos objetos");
		}
		
		if(p1.equals(p2)) {
			System.out.println("repsentan el mismo producto");
		}else {
			System.out.println("repsentan distintos productos");
		}
	}

}
