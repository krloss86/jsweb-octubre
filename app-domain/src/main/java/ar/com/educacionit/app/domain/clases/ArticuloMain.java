package ar.com.educacionit.app.domain.clases;

import ar.com.educacionit.clase5.BuscadorException;

public class ArticuloMain {

	public static void main(String[] args) {
		
		String claveBuscadaPorUsuario = ArticuloMainHelper.obtenerClaveDeBusqueda();

		//crear el buscado, con la clave buscada
		
		Buscador buscador = new Buscador(claveBuscadaPorUsuario);
		
		try {
			buscador.buscar();
		} catch (BuscadorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Integer cantResultados = buscador.getCantResult();
		
		System.out.println("Se han encontrado " + cantResultados + " articulos");
		
		//recorrer el vector de Articulo e ir mostrando cada articulo por consola 
		
		for(int i=0; i < cantResultados; i++) {
			
			//otengo cada articulo dentro del objeto buscador
			Articulo resultado = buscador.obtenerArticuloPorPosicion(i);
			
			if(resultado != null) {
				//mostar los datos del articulo
				System.out.println("Titulo: " + resultado.getTitulo());
				System.out.println("Autor: " + resultado.getAutor());
				System.out.println("Precio: " + resultado.getPrecio());
				System.out.println("Categoria: " + resultado.getCatogoria());
				
				if(resultado.tieneImagen()) {
					System.out.println("Imagen: " + resultado.getUrlImagen());
				}else {
					System.out.println("Imagen Generica");
				}
				
				if(resultado.tieneMasImagenes()) {
					for(String imagen : resultado.getUrlMasImagenes()) {
						System.out.println("Imagen: " + imagen);
					}
				}
				
				if(resultado instanceof Libro) {
					Libro libro = (Libro)resultado;
					System.out.println("ISBN: " +  libro.getIsbn());
				}
				if(resultado instanceof Pelicula) {
					Pelicula pelicula = (Pelicula)resultado;
					System.out.println("Duración: " + pelicula.getDuracion());
				}
			}
			System.out.println("------------");
		}
		
		System.out.println("fin del programa");
	}

}
