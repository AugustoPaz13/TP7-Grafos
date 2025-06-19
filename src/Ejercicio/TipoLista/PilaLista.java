package Ejercicio.TipoLista;

import Ejercicio.Nodo;

public class PilaLista {
    private Nodo cima;

    public PilaLista() {
        cima = null;
    }

    public void insertar(Object elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public Object quitar() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        Object elemento = cima.dato;
        cima = cima.siguiente;
        return elemento;
    }

    public boolean pilaVacia() {
        return cima == null;
    }

    public void limpiarPila() {
        cima = null;
    }
}
