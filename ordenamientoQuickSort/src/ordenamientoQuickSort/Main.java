package ordenamientoQuickSort;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main instanciaPrincipal= new Main();
	}
	
	public Main() {
		Random aleatorio = new Random(System.currentTimeMillis());
		int[] vector = new int[10];
		
		System.out.println("Lista desordenada");
		
		for(int i = 0; i < vector.length; i++) {
			vector[i] = aleatorio.nextInt(10);
			
			System.out.println(vector[i]+"  ");
			
		}
		System.out.println("Lista ordenada");
		
		ordenamientoQuickSort(vector);
		
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]+"  ");
		}
	}
	
	public int[] ordenamientoQuickSort(int[] vector) {
		ordenConRecursividad(vector, 0, vector.length-1);
		return vector;
	}
	
	public void ordenConRecursividad(int vector[], int primero, int ultimo ) {
		int i = 0, j = 0, central = 0, pivote = 0;
		central = (primero + ultimo)/2;
		pivote = vector[central];
		i = primero;
		j = ultimo;
		do {
			while(vector[i] < pivote) {i++;}
			while(vector[j] > pivote){j--;}
			if(i <= j) {
				int aux = vector[i];
				vector[i] = vector[j];
				vector[j] = aux;
				
				i++;j--;
			}
		}while(i <= j);
		
		if(primero < j) {
			ordenConRecursividad(vector, primero, j);
		}
		if(i < ultimo) {
			ordenConRecursividad(vector, i, ultimo);
		}
	}

}
