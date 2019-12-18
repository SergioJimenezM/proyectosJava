package controlador;

import java.io.Serializable;

import modelo.Nodo;
import modelo.Persona;

public class Lista implements Serializable {
	private static final long serialVersionUID = 1878121036592180902L;

	Nodo inicio = null;
	Nodo ultimo = null;
	Nodo indice = null;
	public void agregar(Nodo nuevo) {

		if (inicio != null) {
			ultimo.siguiente = nuevo;
			nuevo.anterior = ultimo;
			ultimo = nuevo;
		}else {
			inicio = ultimo = nuevo;
		}
	}

	public Nodo buscar(int dni){
		Nodo indice = inicio;
		while(indice != null) {
			if(indice.dato.getDni() == dni) {
				this.indice = indice;
				return indice;
			}
			indice = indice.siguiente;
		}
		return null;
	}

	public Nodo Siguiente() {
		if(indice != null && indice.siguiente != null) {
			indice = indice.siguiente;
		}else{
			indice = inicio;
		}
		return indice;
	}
	public Nodo Anterior() {
		if(indice != null && indice.anterior != null) {
			indice = indice.siguiente;
		}else{
			indice = ultimo;
		}
		return indice;
	}

	public void eliminar(){
		if(indice == inicio) {
			inicio = inicio.siguiente;
		} else if(indice == ultimo) {
			ultimo = ultimo.anterior;
		} else {
			indice.anterior.siguiente = indice.siguiente;
			indice.siguiente.anterior = indice.anterior;
		}
		indice = null;
	}
	
	public void actualizar(Persona editado){
		indice.dato = editado;
	}

	public String listar() {
		String salida = null;
		Nodo indice = inicio;
		while(indice != null) {
			salida += indice.dato.mostrar()+"\n\n";
			indice = indice.siguiente;
		}
		if(salida != null) {
		return salida;
		} else {return "No hay datos";} 
	}

}
