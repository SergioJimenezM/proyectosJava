package modelo;

import java.io.Serializable;

public class Nodo implements Serializable{
	private static final long serialVersionUID = 5551877868232817974L;
	
	public Nodo siguiente;
	public Nodo anterior;
	public Persona dato;
}
