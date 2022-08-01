package arbolavl;

import javax.swing.JOptionPane;

/**
 * @author Sergio Jimenez
 */
public class ArbolAVL {

    public static void main(String[] args) {
        AVL arbol = new AVL();
        int op = 0;

        while (true) {
            op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para mas elementos, 2 para mostrar y 3 para esta"));
            switch (op) {
                case 1:{
                    arbol.agregarElemento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero")));
                break;}
                case 2:{
                    JOptionPane.showMessageDialog(null, " esta .|.");
                break;}
                case 3:{
                    System.exit(0);
                break;}
            }
        }
    }

}
