package ar.com.educacionit.clase4.main;

import ar.com.educacionit.clase4.Cliente;
import ar.com.educacionit.clase4.Domicilio;
import ar.com.educacionit.clase4.Persona;
import ar.com.educacionit.clase4.Producto;
import ar.com.educacionit.clase4.Telefono;

public class Clase4Main {

	public static void main(String[] args) {
		
		//posible, crear clase inline
		
		//Persona persona1 = new Persona();// no es posible
		
		//Cliente cliente = new Persona();? NO, por qué? Cliente es hija de Persona
		
		Cliente cliente = new Cliente(); //usar contructor vacio
		
		Telefono telefonoCliente2 = new Telefono(1,"CELULAR","11223344");				
		Cliente cliente2 = new Cliente(1, "carlos", "lopez", telefonoCliente2, 1);
		
		//domicilio
		Domicilio domicilioCliente2 = new Domicilio(1, "siempre viva", "sprinfield", 1234);
		cliente2.setDomicilio(domicilioCliente2);
				
		Producto producto = new Producto(1, 1500, "termo lumilagro");
		
		System.out.println(cliente.toString());
		
		System.out.println(cliente2);
		
		System.out.println(producto.toString());
		
		System.out.println(cliente2.getNombreCompleto());
	}
}
