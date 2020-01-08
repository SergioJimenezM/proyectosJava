package ordenamientoPorIntercambio;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		/*elimina el mensaje de error que dice instancia no utilizada*/
		Main instanciarPrincipal = new Main();
	}
	
	public Main() {
		Random aleatorio = new Random(System.currentTimeMillis());
		int[] vector = new int[10];
		
		System.out.println("Lista desordenada");
		
		for(int i = 0; i < vector.length; i++) {
			vector[i] = aleatorio.nextInt(10);
			
			System.out.println(vector[i]+" ");
			
		}
		System.out.println("Lista ordenada");
		vector = ordenarConIntercambios(vector);
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]+" ");
		}
	}
	
	private int[] ordenarConIntercambios(int[] vectorDesordenado) {
		for(int i  = 0; i < vectorDesordenado.length; i++) {
			
			for(int j = 0; j < vectorDesordenado.length; j++) {
				
				if(vectorDesordenado[i] < vectorDesordenado[j]) {
					int aux = vectorDesordenado[i];/*se extrae el elemento menor*/
					vectorDesordenado[i] = vectorDesordenado[j]; /*se coloca el mayor donde estaba el menor*/
					vectorDesordenado[j] = aux;/*se coloca el menor donde estaba el mayor*/
				}
				
			}/*cierre del primer for*/
			
		}/*cierre del segundo for*/
		return vectorDesordenado;/*ordenado*/
	}/*fin de ordenamiento*/

}
