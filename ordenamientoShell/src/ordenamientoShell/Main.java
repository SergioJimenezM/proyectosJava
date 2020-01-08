package ordenamientoShell;

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
		
		vector = ordenamientoShell(vector);
		
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]+"  ");
		}
		
	}
	
	public int[] ordenamientoShell(int[] vector) {
		int intervalo = 0, i = 0, cambios = 0;
		intervalo = vector.length;
		do {
			intervalo = intervalo / 2;
			do {
				cambios = 0;
				i = -1;
				do {
					i++;
					if(vector[i] > vector[i+intervalo]) {
						/*a, i , i+intervalo*/
						int auxiliar = vector[i];
						vector[i] = vector[i+intervalo];
						vector[i+intervalo] = auxiliar;
						cambios = 1;
					}
				}while(i + intervalo != vector.length-1);
			}while(cambios != 0);
		}while(intervalo != 1);
		
		return vector;
	}

}
