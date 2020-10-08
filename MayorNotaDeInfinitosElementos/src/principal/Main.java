package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int promedio = 0, mayor = 0, menor = 100, nota = 0;
		Scanner entrada = new Scanner(System.in);
		ArrayList<Integer> lista = new ArrayList<Integer>();
		boolean condicion = true;
		while(condicion) {
			System.out.println("Ingrese la nota del estudiante o un -1 para salir");
			
			nota = entrada.nextInt();
			if(nota != -1) {
				lista.add(nota);
			}else {condicion = false;}
		}
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i) > mayor) {
				mayor = lista.get(i);
			}
			if(lista.get(i) < menor) {
				menor = lista.get(i);
			}
			promedio += lista.get(i);
		}
		promedio = promedio/lista.size();
		System.out.println("La menor nota es: "+menor+" la mayor nota es "+mayor+" el promedio es "+promedio);
	}
}