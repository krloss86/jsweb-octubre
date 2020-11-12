package ar.com.educacionit.queue;

import java.util.Comparator;

import ar.com.educacionit.domain.Producto;

public class ProductoTipo1 extends Orden implements Comparator<Producto> {

	public ProductoTipo1(boolean orden) {
		super(orden);
	}
	
	@Override
	public int compare(Producto p1, Producto p2) {
		if(orden)  {//ascendete
			return p1.getTipoProducto().compareTo(p2.getTipoProducto());
		}else {
			return p2.getTipoProducto().compareTo(p1.getTipoProducto());
		}
	}

}
