package Ejercicio.Grafo;

public class Vertice {
    String nombre;
    int numVertice;

    public Vertice(String x) {
        nombre = x;
        numVertice = -1; // Valor inicial para indicar que no ha sido asignado
    }

    public String nomVertice() { // Devuelve identificador del vértice
        return nombre;
    }

    public boolean equals(Vertice n) { // true, si dos vértices son iguales
        return nombre.equals(n.nombre);
    }

    public void asigVert(int n) { // Establece el número de vértices
        numVertice = n;
    }

    public String toString() { // Características del vértice
        return nombre + " (" + numVertice + ")";
    }
}
