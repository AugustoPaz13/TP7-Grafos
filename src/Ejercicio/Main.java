package Ejercicio;

import Ejercicio.Grafo.Matriz;
import Ejercicio.Grafo.Recorrer;
import Ejercicio.Grafo.Vertice;

public class Main {
    static final int CLAVE = 0xffff;

    public static void main(String[] args) {
        int n = 5; // Número de vértices del grafo proporcionado
        Matriz ga; // Grafo original
        Matriz gaInverso; // Grafo inverso

        try {
            ga = new Matriz(n);
            gaInverso = new Matriz(n);

            int[] m; // Array para los resultados de los recorridos
            int[] descendentes = new int[n]; // Vértices alcanzables en el grafo original
            int[] ascendentes = new int[n]; // Vértices alcanzables en el grafo inverso
            int[] bosque = new int[n]; // Marca los vértices ya incluidos en una componente

            //Construir el grafo original con la matriz del grafo 15.9
            entradaGrafo(ga, n);

            //Imprimir la matriz de adyacencia del grafo original
            ga.imprimirMatrizAdyacencia();

            //Construir el grafo inverso
            grafoInverso(ga, gaInverso, n);

            Vertice[] vs = ga.vertices(); // Obtener los vértices para referenciarlos por nombre

            // Inicializar el array 'bosque' que lleva el seguimiento de vértices ya en componentes
            for (int i = 0; i < n; i++)
                bosque[i] = 0;

            int v = 0; // Vértice de partida inicial
            boolean grafoConexo = true; // Determina si el grafo es fuertemente conexo

            // Bucle para encontrar todas las componentes fuertemente conexas
            do {
                System.out.println("\n--- Procesando Componente desde " + vs[v].nomVertice() + " ---");

                // Recorrido en profundidad en el grafo original
                // Obtiene los vértices descendentes
                m = Recorrer.recorrerProf(ga, vs[v].nomVertice());
                for (int i = 0; i < n; i++) {
                    descendentes[i] = (m[i] != CLAVE) ? 1 : 0; // 1 si visitado, 0 si no
                }

                // Recorrido en profundidad en el grafo inverso
                // Obtiene los vértices ascendentes
                m = Recorrer.recorrerProf(gaInverso, vs[v].nomVertice());
                for (int i = 0; i < n; i++) {
                    ascendentes[i] = (m[i] != CLAVE) ? 1 : 0; // 1 si visitado en inverso, 0 si no
                }

                // La intersección de descendentes y ascendentes forma una Componente Fuertemente Conexa
                System.out.print("\nComponente fuertemente conexa: { ");
                int contarComponentesMiembros = 0;
                for (int i = 0; i < n; i++) {
                    if (descendentes[i] == 1 && ascendentes[i] == 1) { // Si está en ambos conjuntos
                        System.out.print(vs[i].nomVertice() + " ");
                        bosque[i] = 1; // Marcar el vértice como parte de una componente
                        contarComponentesMiembros++;
                    }
                }
                System.out.println("}");

                // Si esta componente no cubrió todos los vértices, el grafo no es fuertemente conexo globalmente
                if (contarComponentesMiembros < n && v == 0) {
                    grafoConexo = false;
                }

                //Busca el siguiente vértice no visitado para encontrar otra componente
                v = todosArboles(bosque, n); // Devuelve el índice del próximo vértice no marcado, o -1 si todos marcados
            } while (v != -1); // Repetir hasta que todos los vértices hayan sido procesados

            // Determina si el grafo es fuertemente conexo
            boolean allVerticesCoveredInSingleComponent = true;
            for (int i = 0; i < n; i++) {
                if (bosque[i] == 0) {
                    allVerticesCoveredInSingleComponent = false;
                    break;
                }
            }

            if (grafoConexo && allVerticesCoveredInSingleComponent) {
                System.out.println("\nEl grafo es **fuertemente conexo**.");
            } else {
                System.out.println("\nEl grafo **NO** es fuertemente conexo.");
            }

        } catch (Exception e) {
            System.err.println("Error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    } 

    // Metodo para crear el grafo inverso
    static void grafoInverso(Matriz g, Matriz x, int n) throws Exception {
        Vertice[] vr = g.vertices();
        for (int i = 0; i < n; i++)
            x.nuevoVertice(vr[i].nomVertice()); // Añade los mismos vértices al grafo inverso
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (g.adyacente(i, j)) x.nuevoArco(j, i); // Invierte la dirección de los arcos
    }

    //Metodo para encotrar
    static int todosArboles(int[] bosque, int n) {
        for (int i = 0; i < n; i++) {
            if (bosque[i] == 0) { // Si el vértice no ha sido marcado
                return i; // Devuelve su índice
            }
        }
        return -1; // Todos los vértices han sido marcados
    }

    // Metodo para dar entrada al grafo a partir de la matriz proporcionada por el usuario
    static void entradaGrafo(Matriz gr, int n) throws Exception {
        // Nombres de los vértices en el orden
        String[] nombres = {"Alicante", "Barcelona", "Cartagena", "Murcia", "Reus"};
        // Matriz de adyacencia del grafo (convertida a 0/1 para existencia de arco)
        int[][] matrizAdyacencia = {
                //  Al.  Bar. Car. Mur. Re.
                {0, 0, 5, 5, 0},   // Alicante
                {0, 0, 3, 6, 3},   // Barcelona
                {3, 0, 0, 0, 0},   // Cartagena
                {0, 2, 0, 0, 0},   // Murcia
                {0, 3, 0, 0, 0}    // Reus
        };

        // Añade vértices al grafo
        for (int i = 0; i < n; i++) {
            gr.nuevoVertice(nombres[i]);
        }

        // Añade arcos al grafo (convertir pesos a 1 para existencia de arco)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrizAdyacencia[i][j] != 0) { // Si hay un peso, hay un arco
                    gr.nuevoArco(i, j); // El metodo nuevoArco de GrafoMatriz lo guarda como 1
                }
            }
        }
    }
}
