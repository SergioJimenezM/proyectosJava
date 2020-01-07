package gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ArbolBin;
import dao.Nodo;

public class Main {
	ArbolBin arbol = new ArbolBin(); 
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main m = new Main();
	}
	
	public Main(){
			JFrame ventana = new JFrame("Arbol binario");
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setLayout(new BorderLayout());/*alinea componentes en los bordes*/
			ventana.setSize(new Dimension(640,400));/*tamaño de la ventana en (x,Y)*/
			ventana.setLocationRelativeTo(null);/*colocar la ventana conrespecto al centro*/
			
			JPanel derecho = new JPanel();/*panel derecho*/
			derecho.setLayout(new BorderLayout());
			JTextArea mostrador = new JTextArea("No hay datos", 20, 25 );/*mensaje predefinido y tamaño aproximado en letras*/
			mostrador.setEditable(false);/*el texto no se puede editar*/
			JScrollPane areaDeDesplazamiento = new JScrollPane();/*bandas para desplazar*/
			areaDeDesplazamiento.setViewportView(mostrador);/*dentro va el area de texto*/
			areaDeDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);/*horizontal si se necesita*/
			areaDeDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);/*vertical siempre*/
			derecho.add(areaDeDesplazamiento, BorderLayout.CENTER);/*añadir el panel de desplazamiento en el centro del panel derecho*/
			ventana.add(derecho, BorderLayout.EAST);/*panel derecho a la derecha de la ventana*/
			
			JPanel izquierdo = new JPanel();/*panel izquierdo*/
			izquierdo.setLayout(new GridBagLayout());
			
			JLabel lNumeroPorGuardar = new JLabel("Numero:");
			GridBagConstraints restriccionLblNumeroPorGuardar = new GridBagConstraints();/*limites para el componente*/
			restriccionLblNumeroPorGuardar.gridheight = 1;/*alto del componente*/
			restriccionLblNumeroPorGuardar.gridwidth = 1;/*ancho del componente*/
			restriccionLblNumeroPorGuardar.gridx = 0;/*posicion x en la rejilla*/
			restriccionLblNumeroPorGuardar.gridy = 0;/*posicion y en la rejilla*/
			izquierdo.add(lNumeroPorGuardar, restriccionLblNumeroPorGuardar);/*se añade el objeto y sus restricciones*/
			
			JTextField jtfNumeroPorGuardar = new JTextField(15);
			GridBagConstraints restriccionJtfNumeroPorGuardar = new GridBagConstraints();
			restriccionJtfNumeroPorGuardar.gridheight = 1;
			restriccionJtfNumeroPorGuardar.gridwidth = 1;
			restriccionJtfNumeroPorGuardar.gridx = 1;
			restriccionJtfNumeroPorGuardar.gridy = 0;
			izquierdo.add(jtfNumeroPorGuardar, restriccionJtfNumeroPorGuardar);
			
			JButton btnNuevoNodo = new JButton("Nuevo nodo");
			GridBagConstraints restriccionBtnNuevoNodo = new GridBagConstraints();
			restriccionBtnNuevoNodo.gridheight = 1;
			restriccionBtnNuevoNodo.gridwidth = 1;
			restriccionBtnNuevoNodo.gridx = 1;
			restriccionBtnNuevoNodo.gridy = 1;
			/*este metodo es lo que hace el boton al ser presionado*/
			btnNuevoNodo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Nodo nuevo = new Nodo();
					try {
					nuevo.dato = Integer.parseInt(jtfNumeroPorGuardar.getText());
					boolean resultado = arbol.insertar(nuevo);
					if(resultado){
						JOptionPane.showMessageDialog(null, "Se ha insertado correctamente el elemento", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
					}
					mostrador.setText(arbol.iniciarInOrden());
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "El arbol solo acepta numeros\n"+e.getMessage(), "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			/*fin de declaración*/
			izquierdo.add(btnNuevoNodo, restriccionBtnNuevoNodo);
			ventana.add(izquierdo, BorderLayout.WEST);
			
			JButton balancearArbol = new JButton("Balancear Arbol");
			balancearArbol.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					arbol.balancearArbol();
					mostrador.setText(arbol.iniciarPreOrden());
				}
			});
			GridBagConstraints restriccionesBalancearArbol = new GridBagConstraints();
			restriccionesBalancearArbol.gridheight = 1;
			restriccionesBalancearArbol.gridwidth = 1;
			restriccionesBalancearArbol.gridx = 1;
			restriccionesBalancearArbol.gridy = 2;
			izquierdo.add(balancearArbol, restriccionesBalancearArbol);
			
			ventana.setVisible(true);/*la ventana se hace visible*/
			ventana.repaint();
			/*
			 *se repinta la ventana por que setLocationRelativeTO es especial
			 *sin repintar la ventana los componentes no se muestran
			 *tambien se podría usar pack pero eso causa que el setSize
			 *sea inútil, setSize define el tamaño de la ventana,
			 *el pack redimenciona la ventana y quita el espacio en blanco
			 *por tanto se usa uno o el otro, según se quiera, pero no ambos
			 */
	}/*fin de constructor*/

}/*fin de clase*/
