package Ejercicio.TipoCola;

import Ejercicio.Nodo;

public class ColaLista {
    protected Nodo frente;
    protected Nodo fin;

    public ColaLista() {
        frente = null;
        fin = null;
    }

    public void insertar(Object elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (colaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
    }

    public Object quitar() throws Exception {
        if (colaVacia()) {
            throw new Exception("Cola vacía, no se puede extraer.");
        }
        Object elemento = frente.dato;
        frente = frente.siguiente;
        if (frente == null) { // Si la cola se vacía después de quitar
            fin = null;
        }
        return elemento;
    }

    public boolean colaVacia() {
        return frente == null;
    }

    public void borrarCola() {
        frente = null;
        fin = null;
    }
}
