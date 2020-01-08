package ordenamientoPorBurbuja;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main instanciaPrincipal = new Main();
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
		vector = ordenamientoBurbuja(vector);
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]+"  ");
		}
	}
	
	public int[] ordenamientoBurbuja(int[] vector){
		for(int i = 0; i < vector.length; i++) {
			
			for (int j = 0; j < vector.length-1; j++) {
				if(vector[j+1] < vector[j]) {
					int aux = vector[j+1];
					vector[j+1] = vector[j];
					vector[j] = aux;
				}
			}
		}
		return vector;
	}

}
