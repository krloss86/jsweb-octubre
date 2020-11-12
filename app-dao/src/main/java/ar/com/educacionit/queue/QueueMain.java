package ar.com.educacionit.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

	public static void main(String[] args) {
	
		//crear
		Queue<String> lista2 = new LinkedList<String>();
		
		//agrega
		lista2.offer("Simon");
		lista2.offer("Juan");
		lista2.offer("Pedro");
		lista2.offer("Carlos");
		
		while(!lista2.isEmpty()) {
			System.out.println("Cliente en cola: " +lista2 );
			
			System.out.println("Ste es: " + lista2.peek());
			
			System.out.println("LLamado para : " + lista2.poll());
		}
		System.out.println("Se ha atendido todos");
	}

}
