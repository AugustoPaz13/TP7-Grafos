package Ejercicio.Grafo;

public class Matriz {
    int numVerts;
    static final int MaxVerts = 20; // Tamaño máximo preestablecido
    Vertice[] verts;
    int[][] matAd;

    // Constructor sin argumentos [5]
    public Matriz() {
        this(MaxVerts);
    }

    // Constructor con número máximo de vértices [5]
    public Matriz(int mx) {
        matAd = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++)
            for (int j = 0; j < mx; j++)
                matAd[i][j] = 0; // Inicializa la matriz a 0
        numVerts = 0;
    }

    // Añade un nuevo vértice al grafo
    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom);
            v.asigVert(numVerts);
            verts[numVerts++] = v;
        }
    }

    // Busca el vértice por nombre y devuelve su índice, -1 si no lo encuentra
    public int numVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = verts[i].equals(v);
            if (!encontrado) i++;
        }
        return (i < numVerts) ? i : -1;
    }

    // Añade un arco por nombres de vértices
    public void nuevoArco(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        matAd[va][vb] = 1; // Marca la adyacencia con 1
    }

    // Añade un arco por índices de vértices
    public void nuevoArco(int va, int vb) throws Exception {
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        matAd[va][vb] = 1;
    }

    // Determina si dos vértices forman un arco por nombres
    public boolean adyacente(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        return matAd[va][vb] == 1;
    }

    // Determina si dos vértices forman un arco por índices
    public boolean adyacente(int va, int vb) throws Exception {
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        return matAd[va][vb] == 1;
    }

    // Devuelve el número actual de vértices
    public int numeroDeVertices() {
        return numVerts;
    }

    // Devuelve el array de vértices
    public Vertice[] vertices() {
        return verts;
    }

    // Metodo para imprimir la matriz de adyacencia
    public void imprimirMatrizAdyacencia() {
        System.out.println("\nMatriz de Adyacencia del Grafo 15.9:");
        //Imprime columnas
        System.out.print("       ");
        for (int i = 0; i < numVerts; i++) {
            System.out.printf("%-10s", verts[i].nomVertice());
        }
        System.out.println();

        // Imprime filas y datos
        for (int i = 0; i < numVerts; i++) {
            System.out.printf("%-10s", verts[i].nomVertice());
            for (int j = 0; j < numVerts; j++) {
                System.out.printf("%-10d", matAd[i][j]);
            }
            System.out.println();
        }
    }
}
