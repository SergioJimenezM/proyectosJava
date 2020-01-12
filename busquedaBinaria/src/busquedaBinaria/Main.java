package busquedaBinaria;

import javax.swing.JOptionPane;

public class Main {
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main instanciaPrincipal = new Main();
	}
	
	public Main() {
		int[] vector = new int[10];
		
		System.out.println("Lista desordenada");
		
		for(int i = 0; i < vector.length; i++) {
			vector[i] = i * 2;
			
			System.out.println(vector[i]+" ");
			
		}
		int porBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero a buscar"));
		System.out.println("Elemento encontrado: " + busquedaBinaria(vector, 0, vector.length-1, porBuscar));
	}
	
	/*Solo funciona en arreglos ordenados, se debe ordenar antes de ejecutar la busqueda*/
	public int busquedaBinaria(int vector[], int limiteMinimo, int limiteMaximo, int porBuscar) {
		/* se tienen tres limites, el menor valor, el mayor y el medio
		 * el medio indicará si buscar en la parte derecha o izquierda del arreglo
		 * si no es menor o mayor, significa que el valor por buscar es el medio
		 * se dividirá el arreglo una y otra vez hasta que el medio sea el elemento por buscar
		 */
		int limiteMedio = (limiteMinimo + limiteMaximo) / 2;
		
		if(vector[limiteMaximo] >= porBuscar && vector[limiteMinimo] <= porBuscar){
			if(vector[limiteMedio] > porBuscar) {
				return busquedaBinaria(vector, limiteMinimo, limiteMedio, porBuscar);
			}else if(vector[limiteMedio] < porBuscar) {
				return busquedaBinaria(vector, limiteMedio, limiteMaximo, porBuscar);
			}else {
				return vector[limiteMedio];
			}
		}
		return -1;/*no se ha encontrado el elemento*/
	}
	

}
