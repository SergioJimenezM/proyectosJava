package arbolavl;

public class AVL {

    Nodo raiz;

    public AVL() {
        this.raiz = null;
    }

    public void vaciarArbol() {
        raiz = null;
    }

    public void agregarElemento(int dato) {
        raiz = insertando(dato, raiz);
    }

    private Nodo insertando(int dato, Nodo nuevo) {
        if (nuevo == null) {
            nuevo = new Nodo(dato);
        } else if (dato < nuevo.dato) {
            nuevo.izquierda = insertando(dato, nuevo.izquierda);

            if (obtenerAltura(nuevo.izquierda) - obtenerAltura(nuevo.derecha) == 2) {
                if(dato < nuevo.izquierda.dato){
                    nuevo = rotarALaIzquierda(nuevo);
                }else{
                    nuevo = dobleRotacionIzquierda(nuevo);
                }
            }
        }else if(dato > nuevo.dato){
            nuevo.derecha = insertando(dato, nuevo.derecha);
            if(obtenerAltura(nuevo.derecha) - obtenerAltura(nuevo.izquierda) == 2){
                if(dato > nuevo.derecha.dato){
                    nuevo = rotarALaDerecha(nuevo);
                }else{
                    nuevo = dobleRotacionDerecha(nuevo);
                }
            }
        }
        nuevo.alto = calcularAlturaMaxima(obtenerAltura(nuevo.izquierda), obtenerAltura(nuevo.derecha)) + 1;
        
        return nuevo;
    }

    private int obtenerAltura(Nodo nuevo) {
        return nuevo == null ? -1 : nuevo.alto;
    }

    private int calcularAlturaMaxima(int alturaIzquierda, int alturaDerecha) {
        return alturaIzquierda > alturaDerecha ? alturaIzquierda : alturaDerecha;
    }

    private Nodo rotarALaIzquierda(Nodo nuevo) {
        Nodo izquierda = nuevo.izquierda;
        nuevo.izquierda = izquierda.derecha;
        izquierda.izquierda = nuevo;

        nuevo.alto = calcularAlturaMaxima(obtenerAltura(nuevo.izquierda), obtenerAltura(nuevo.derecha)) + 1;
        izquierda.alto = calcularAlturaMaxima(obtenerAltura(izquierda.izquierda), nuevo.alto) + 1;

        return izquierda;
    }

    private Nodo rotarALaDerecha(Nodo nuevo) {
        Nodo derecha = nuevo.derecha;
        nuevo.derecha = derecha.izquierda;
        derecha.izquierda = nuevo;
        
        nuevo.alto = calcularAlturaMaxima(obtenerAltura(nuevo.izquierda), obtenerAltura(nuevo.derecha))+1;
        derecha.alto = calcularAlturaMaxima(obtenerAltura(derecha.derecha), nuevo.alto)+1;
        
        return derecha;
    }
    
    private Nodo dobleRotacionIzquierda(Nodo nuevo){
        nuevo.izquierda = rotarALaDerecha(nuevo.izquierda);
        return rotarALaIzquierda(nuevo);
    }
    
    private Nodo dobleRotacionDerecha(Nodo nuevo){
        nuevo.derecha = rotarALaIzquierda(nuevo.derecha);
        return rotarALaDerecha(nuevo);
    }
    
    public int cantidadDeNodos(){
        return contarNodos(this.raiz);
    }
    
    private int contarNodos(Nodo raiz){
        if(raiz == null){
            return 0;
        }else{
            int nodos = 1;
            nodos += contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
            return nodos;
        }
    }

}
