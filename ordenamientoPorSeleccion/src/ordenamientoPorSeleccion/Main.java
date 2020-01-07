package ordenamientoPorSeleccion;

import javax.swing.JOptionPane;

public class Main {

	int numeros[] = {15, 3, 90, 38, 1, 10, 2};
	Nodo inicio = new Nodo();
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main m = new Main();
	}/*fin del main*/
	
	public Main(){
		Nodo ultimo = inicio;
		for(int i = 0; i < 7; i++){
			ultimo.numero = numeros[i];/*lleno un nodo vacio*/
			if(i != 6){/*si es el sexto elemento no hay un septimo*/
			ultimo.sgt = new Nodo();/*creo un nuevo nodo*/
			ultimo = ultimo.sgt;/*avanzo al nodo vacio*/
			}
		}
		
		Nodo vector[] = vectorizador(inicio);
		JOptionPane.showMessageDialog(null, imprimir(vector));
		
		/*<<<<<<<-----ALGORITMO AQUI----->>>>>>>*/
		 for (int i = 0; i < vector.length - 1; i++)
		    {
		        int index = i;
		        for (int j = i + 1; j < vector.length; j++)
		            if (vector[j].numero < vector[index].numero){/*buscando numero menor*/
		                index = j;/*posicion del intercambio*/
		            }
		        Nodo numeroMenor/*guarda el mayor*/ = vector[index];/*Intercambio*/
		        vector[index] = vector[i];/*pone el menor aqui*/
		        vector[i] = numeroMenor;/*pone el numero mayor, donde estaba el menor*/

		    }
		/*<<<<<<<-----FIN DE ALGORITMO----->>>>>>>*/
		
		JOptionPane.showMessageDialog(null, imprimir(vector));
	}/*fin de constructor*/

	public Nodo[] vectorizador(Nodo primero){
		/*primero es el nodo inicio para recorrer la lista*/
		Nodo index = primero;
		Nodo vector[] = new Nodo[numeros.length];/*se deber�an contar los nodos, eso se hace en la clase lista*/
		int contador = 0;
		while(index != null){
			vector[contador] = index;
			index = index.sgt;
			contador++;
		}
		return vector;
	}/*convierte una lista enlazada en un vector*/
	
	public String imprimir(Nodo vector[]){
		String sale = "";
		for(int i = 0; i < 7; i++){
			sale += vector[i].numero+"\n";
		}
		return sale;
	}
}/*fin de clase*/
