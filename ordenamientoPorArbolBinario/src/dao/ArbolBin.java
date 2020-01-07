package dao;

import java.util.LinkedList;
import java.util.ListIterator;

public class ArbolBin {
Nodo raiz = null;
String salida = "";
private boolean condicion;
private int numeroDeNodos = 0;

public boolean insertar(Nodo nuevo){
	condicion = false;
	if(raiz == null) {
		nuevo.esDerecha = null;
		raiz = nuevo;
		numeroDeNodos = 1;
		return true;
	}
	insercionRecursiva(nuevo, raiz);
	return condicion;
}

private void insercionRecursiva(Nodo nuevo, Nodo principal){
	if(nuevo.dato < principal.dato) {
		if(principal.izquierda == null) {
			principal.izquierda = nuevo;
			nuevo.esDerecha = false;
			condicion = true;
			numeroDeNodos++;
			return;
		}else {
			insercionRecursiva(nuevo, principal.izquierda);
		}
	}else{
		if(principal.derecha == null) {
			principal.derecha = nuevo;
			nuevo.esDerecha = true;
			condicion = true;
			numeroDeNodos++;
			return;
		}else {
			insercionRecursiva(nuevo, principal.derecha);
		}
	}/*fin de insercion recursiva*/
}

public int getNumeroDeNodos() {
	return numeroDeNodos;
}
LinkedList<Nodo> listado;
public void balancearArbol() {
	listado = new LinkedList<Nodo>();
	listadorEnOrden(raiz);
	raiz = null;/*quitamos la raíz para reordenar*/
	/*recorremos los nodos quitando las conexiones*/
	ListIterator<Nodo> iterador = (ListIterator<Nodo>)listado.listIterator();
	while(iterador.hasNext()) {
		try {
			Nodo temp = iterador.next();
			temp.izquierda = null;
			temp.derecha = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}/*fin de recorrido*/
	iterador = null;
	/*reconectamos todo partiendo de el nodo mas central
	 *así el arbol se balancea, destruyendolo y creandolo de nuevo
	 */
	
	while(!listado.isEmpty()) {
		int elemento = ((listado.size() -1)/2);
		insertar(listado.get(elemento));
		listado.remove(elemento);
	}
}

private void listadorEnOrden(Nodo index) {
	if(index == null){return;}
	/*si no hay nodo, se corta la recursividad*/
	listadorEnOrden(index.izquierda);
	listado.add(index);
	listadorEnOrden(index.derecha);
}

/*preOrden significa nodo, izquierda y derecha*/
public String iniciarPreOrden() {
	salida = "";
	if(raiz == null) {return "No hay datos";}
	recorridoPreOrden(raiz);
	return salida;
}

private void recorridoPreOrden(Nodo index) {
	if(index == null) {return;}
	salida += index.dato +" esDerecha " + index.esDerecha + "\n";
	recorridoPreOrden(index.izquierda);
	recorridoPreOrden(index.derecha);
}

/*inorden significa izquierda, nodo y derecha*/
public String iniciarInOrden() {
	salida = "";
	if(raiz == null) {return "No hay datos";}
	recorridoInOrden(raiz);
	return salida;
}
private void recorridoInOrden(Nodo index) {
	if(index == null) {return;}
	recorridoInOrden(index.izquierda);
	salida += index.dato +" esDerecha " + index.esDerecha + "\n";
	recorridoInOrden(index.derecha);
}

/*postOrden significa izquierda, derecha y nodo*/
public String iniciarPostOrden() {
	salida = "";
	if(raiz == null) {return "No hay datos";}
	recorridoPostOrden(raiz);
	return salida;
	
}
private void recorridoPostOrden(Nodo index) {
	if(index == null) {return;}
	recorridoPostOrden(index.izquierda);
	recorridoPostOrden(index.derecha);
	salida += index.dato +" esDerecha " + index.esDerecha + "\n";
}
}/*fin de clase*/
