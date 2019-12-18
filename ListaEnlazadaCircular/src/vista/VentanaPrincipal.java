package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Lista;
import modelo.Nodo;
import modelo.Persona;

public class VentanaPrincipal implements ActionListener {
	JFrame ventana;
	JButton anterior, siguiente, agregar, buscar, eliminar, actualizar;
	JTextField jtfDni, jtfNombre, jtfTelefono;
	JTextArea mostrador;
	
	Lista listaDoblementeEnlazada = new Lista();
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		VentanaPrincipal vp = new VentanaPrincipal();
	}
	
	public VentanaPrincipal(){
		ventana = new JFrame("Lista de contactos");
		ventana.setLayout(new BorderLayout());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		JPanel derecho = new JPanel();
		derecho.setLayout(new FlowLayout());
		mostrador = new JTextArea("No hay datos", 20, 25 );
		mostrador.setEditable(false);
		JScrollPane areaDeDesplazamiento = new JScrollPane();
		areaDeDesplazamiento.setViewportView(mostrador);
		areaDeDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		areaDeDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		derecho.add(areaDeDesplazamiento);
		ventana.add(derecho, BorderLayout.EAST);
		
		JPanel izquierdo = new JPanel();
		izquierdo.setLayout(new GridBagLayout());
		JLabel jlNombre = new JLabel("Nombre: "), jlDni = new JLabel("DNI: "), jlTelefono = new JLabel("Telefono: ");
		jtfDni = new JTextField(15);
		jtfNombre = new JTextField(15);
		jtfTelefono = new JTextField(15);

		GridBagConstraints restriccionLblDni = new GridBagConstraints();
		restriccionLblDni.gridx = 0;
		restriccionLblDni.gridy = 0;
		restriccionLblDni.gridwidth = 1;
		restriccionLblDni.gridheight = 1;
		izquierdo.add(jlDni, restriccionLblDni);
		
		GridBagConstraints restriccionJtfDni = new GridBagConstraints();
		restriccionJtfDni.gridx = 1;
		restriccionJtfDni.gridy = 0;
		restriccionJtfDni.gridwidth = 1;
		restriccionJtfDni.gridheight = 1;
		izquierdo.add(jtfDni, restriccionJtfDni);
		
		GridBagConstraints restriccionJlNombre = new GridBagConstraints();
		restriccionJlNombre.gridx = 0;
		restriccionJlNombre.gridy = 1;
		restriccionJlNombre.gridwidth = 1;
		restriccionJlNombre.gridheight = 1;
		izquierdo.add(jlNombre, restriccionJlNombre);
		
		GridBagConstraints restriccionJtfNombre = new GridBagConstraints();
		restriccionJtfNombre.gridx = 1;
		restriccionJtfNombre.gridy = 1;
		restriccionJtfNombre.gridwidth = 1;
		restriccionJtfNombre.gridheight = 1;
		izquierdo.add(jtfNombre, restriccionJtfNombre);
		
		GridBagConstraints resriccionJlTelefono = new GridBagConstraints();
		resriccionJlTelefono.gridx = 0;
		resriccionJlTelefono.gridy = 2;
		resriccionJlTelefono.gridwidth = 1;
		resriccionJlTelefono.gridheight = 1;
		izquierdo.add(jlTelefono, resriccionJlTelefono);
		
		GridBagConstraints restriccionJtfTelefono = new GridBagConstraints();
		restriccionJtfTelefono.gridx = 1;
		restriccionJtfTelefono.gridy = 2;
		restriccionJtfTelefono.gridwidth = 1;
		restriccionJtfTelefono.gridheight = 1;
		izquierdo.add(jtfTelefono, restriccionJtfTelefono);
		
		agregar = new JButton("Agregar");
		agregar.addActionListener(this);
		GridBagConstraints restriccionAgregar = new GridBagConstraints();
		restriccionAgregar.gridx = 0;
		restriccionAgregar.gridy = 3;
		restriccionAgregar.gridwidth = 1;
		restriccionAgregar.gridheight = 1;
		izquierdo.add(agregar, restriccionAgregar);
		
		buscar = new JButton("Buscar");
		buscar.addActionListener(this);
		GridBagConstraints restriccionBuscar = new GridBagConstraints();
		restriccionBuscar.gridx = 1;
		restriccionBuscar.gridy = 3;
		restriccionBuscar.gridwidth = 1;
		restriccionBuscar.gridheight = 1;
		izquierdo.add(buscar, restriccionBuscar);
		
		actualizar = new JButton("Actualizar");
		actualizar.addActionListener(this);
		GridBagConstraints restriccionActualizar = new GridBagConstraints();
		restriccionActualizar.gridx = 0;
		restriccionActualizar.gridy = 4;
		restriccionActualizar.gridwidth = 1;
		restriccionActualizar.gridheight = 1;
		izquierdo.add(actualizar, restriccionActualizar);
		
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
		GridBagConstraints restriccionEliminar = new GridBagConstraints();
		restriccionEliminar.gridx = 1;
		restriccionEliminar.gridy = 4;
		restriccionEliminar.gridwidth = 1;
		restriccionEliminar.gridheight = 1;
		izquierdo.add(eliminar, restriccionEliminar);
		
		siguiente = new JButton("Siguiente");
		siguiente.addActionListener(this);
		GridBagConstraints restriccionSiguiente = new GridBagConstraints();
		restriccionSiguiente.gridx = 0;
		restriccionSiguiente.gridy = 5;
		restriccionSiguiente.gridwidth = 1;
		restriccionSiguiente.gridheight = 1;
		izquierdo.add(siguiente, restriccionSiguiente);
		
		anterior = new JButton("Anterior");
		anterior.addActionListener(this);
		GridBagConstraints restriccionAnterior = new GridBagConstraints();
		restriccionAnterior.gridx = 1;
		restriccionAnterior.gridy = 5;
		restriccionAnterior.gridwidth = 1;
		restriccionAnterior.gridheight = 1;
		izquierdo.add(anterior, restriccionAnterior);
		
		ventana.add(izquierdo, BorderLayout.WEST);
		
		ventana.pack();
	}
	
	public void agregar(){
		try {
			Persona dato = ingresoDeJtf();
			Nodo nuevo = new Nodo();
			nuevo.dato = dato;
			listaDoblementeEnlazada.agregar(nuevo);
			limpiar();
			mostrar();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Ha ocurrido un error", 0);
		}
	}
	
	public void buscar() {
		Nodo nodo = null;
		try {
			nodo = listaDoblementeEnlazada.buscar(Integer.parseInt(jtfDni.getText()));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e, "Ha ocurrido un error", 0);
		}
		limpiar();
		if(nodo != null) {
		salidaDeJft(nodo);
		}else {
			JOptionPane.showMessageDialog(null, "No se ha encontrado el contacto", "", 0);
		}
	}
	
	public void actualizar() {
		if(jtfDni.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay un nodo para actualizar");
			return;
		}
		int op = JOptionPane.showConfirmDialog(null, "Desea eliminar el contacto?", "pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(op == JOptionPane.YES_OPTION) {
			Persona editado = ingresoDeJtf();
			listaDoblementeEnlazada.actualizar(editado);
		}
	}
	
	public void eliminar() {
		if(jtfDni.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay un nodo para eliminar");
			return;
		}
		int op = JOptionPane.showConfirmDialog(null, "Desea eliminar el contacto?", "pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(op == JOptionPane.YES_OPTION) {
			listaDoblementeEnlazada.eliminar();
			mostrar();
			limpiar();
		}
	}
	
	public void limpiar() {
		jtfDni.setText("");
		jtfNombre.setText("");
		jtfTelefono.setText("");
	}
	
	public Persona ingresoDeJtf() {
		return new Persona(Integer.parseInt(jtfDni.getText()), jtfNombre.getText(), Integer.parseInt(jtfTelefono.getText()));
	}
	
	public void salidaDeJft(Nodo nodo) {
		jtfDni.setText(nodo.dato.getDni()+"");
		jtfNombre.setText(nodo.dato.getNombre());
		jtfTelefono.setText(nodo.dato.getTelefono()+"");
	}
	
	public void mostrar() {
		mostrador.setText(listaDoblementeEnlazada.listar());
	}
	
	public void guardar() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lista,dat"));
			oos.writeObject(listaDoblementeEnlazada);
			oos.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Ha ocurrido un error", 0);
		}
		
	}
	
	public void cargar() {
		try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lista.dat"));
		listaDoblementeEnlazada = (Lista)ois.readObject();
		ois.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Ha ocurrido un error", 0);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(agregar == evento){ 
			agregar();
		}
		
		if(buscar == evento){
			buscar();
		}
		
		if(actualizar == evento){
			actualizar();
		}
		
		if(eliminar == evento){
			eliminar();
		}
		
		if(siguiente == evento) {
			Nodo siguiente = listaDoblementeEnlazada.Siguiente();
			salidaDeJft(siguiente);
		}
		
		if(anterior == evento) {
			Nodo anterior = listaDoblementeEnlazada.Anterior();
			salidaDeJft(anterior);
		}
	}

}
