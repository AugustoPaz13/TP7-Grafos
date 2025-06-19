package Ejercicio.Grafo;

import Ejercicio.TipoCola.ColaLista;
import Ejercicio.TipoLista.PilaLista;

public class Recorrer {
    static final int CLAVE = 0xffff;

    public static int[] recorrerAnchura(Matriz g, String org) throws Exception {
        int w, v;
        int[] m;

        v = g.numVertice(org);
        if (v < 0) throw new Exception("Vértice origen no existe");

        ColaLista cola = new ColaLista();
        m = new int[g.numeroDeVertices()];
        for (int i = 0; i < g.numeroDeVertices(); i++)
            m[i] = CLAVE;
        m[v] = 0;

        cola.insertar(Integer.valueOf(v));
        while (!cola.colaVacia()) {
            Integer cw = (Integer) cola.quitar();
            w = cw.intValue();
            System.out.println("Vértice " + g.vertices()[w] + " visitado (Anchura)");
            for (int u = 0; u < g.numeroDeVertices(); u++)
                if ((g.matAd[w][u] == 1) && (m[u] == CLAVE)) {
                    m[u] = m[w] + 1;
                    cola.insertar(Integer.valueOf(u));
                }
        }
        return m;
    }

    public static int[] recorrerProf(Matriz g, String org) throws Exception {
        int v, w;
        PilaLista pila = new PilaLista();
        int[] m;

        m = new int[g.numeroDeVertices()];
        v = g.numVertice(org);
        if (v < 0) throw new Exception("Vértice origen no existe");
        for (int i = 0; i < g.numeroDeVertices(); i++)
            m[i] = CLAVE;
        m[v] = 0;

        pila.insertar(Integer.valueOf(v));
        while (!pila.pilaVacia()) {
            Integer cw = (Integer) pila.quitar();
            w = cw.intValue();
            System.out.println("Vértice " + g.vertices()[w] + " visitado (Profundidad)");
            for (int k = 0; k < g.numeroDeVertices(); k++) {
                if ((g.matAd[w][k] == 1) && (m[k] == CLAVE)) {
                    pila.insertar(Integer.valueOf(k));
                    m[k] = 1;
                }
            }
        }
        return m;
    }
}
