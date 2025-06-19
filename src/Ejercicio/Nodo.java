package Ejercicio;

public class Nodo {
    public Object dato;
    public Nodo siguiente;

    public Nodo(Object x) {
        dato = x;
        siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setSiguiente(Nodo s) {
        this.siguiente = s;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
