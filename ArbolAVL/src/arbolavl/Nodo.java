package arbolavl;

public class Nodo {

    int dato;
    int alto;
    Nodo derecha;
    Nodo izquierda;

    public Nodo(int dato) {
        this.dato = dato;
        this.alto = 0;
        this.derecha = null;
        this.izquierda = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Nodo getIzquiera() {
        return izquierda;
    }

    public void setIzquiera(Nodo izquiera) {
        this.izquierda = izquiera;
    }
}
