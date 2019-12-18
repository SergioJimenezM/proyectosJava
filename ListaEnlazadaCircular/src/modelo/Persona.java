package modelo;

import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1420107018587459946L;
	
	private int dni;
	private String nombre;
	private int telefono;

	public Persona(int dni,String nombre, int telefono) {
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String mostrar() {
		return "DNI: " + dni + "\nNombre " + nombre + "\nTelefono: " + telefono;
	}

}
