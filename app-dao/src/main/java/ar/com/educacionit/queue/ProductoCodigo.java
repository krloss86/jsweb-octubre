package ar.com.educacionit.queue;

import java.util.Comparator;

import ar.com.educacionit.domain.Producto;

public class ProductoCodigo extends Orden implements Comparator<Producto> {

	public ProductoCodigo(boolean orden) {
		super(orden);
	}
	
	@Override
	public int compare(Producto p1, Producto p2) {
		if(orden) {
			return p1.getCodigo().compareTo(p2.getCodigo());
		}else {
			return p2.getCodigo().compareTo(p1.getCodigo());
		}
			
	}

}
