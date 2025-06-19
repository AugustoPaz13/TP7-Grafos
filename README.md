# TP7-Grafos
Consigna:
Se tiene un grafo dirigido de n nodos, representado por su matriz de adyacencia, A. Se desea
determinar si el grafo es fuertemente conexo, o bien en el caso de que no lo sea, encontrar las
componentes fuertemente conexas. Las compones fuertes se mostrarán por pantalla.
El algoritmo recorre el grafo a partir de un vértice v, y también recorre el grafo inverso
a partir del mismo vértice. El método grafoInverso() crea el grafo inverso, cambiando la
dirección de los arcos originales.
Se parte de cualquier vértice, por ejemplo el primero, para encontrar el conjunto de vértices
que están interconectados. Si son todos, el grafo es fuertemente conexo; en caso contrario, se
repite el proceso a partir de un vértice que no esté formando parte de componentes anteriores.
El recorrido en profundidad a partir de v encuentra los vértices descendientes de v; el recorrido
se repite a partir del mismo vértice, pero con el grafo inverso, los vértices marcados forman los
vértices ascendientes de v. Los vértices marcados en ambos recorridos forman una componente
fuerte del grafo.
Al haber una correspondencia biunívoca entre el número de vértices y los índices de los arrays
de vértices, descendientes[] y ascendientes[], si un vértice i está presente se activa (se
pone a true) la misma posición del array; de esa forma se guarda el vértice en el correspondiente
conjunto. Esto facilita la operación de intersección (vértices comunes) ya que, simplemente, si
se cumple ascendientes[i] && descendientes[i] el nodo i pertenece a ambos conjuntos.
Además, en el array bosque[] se marcan los vértices que ya están formando parte de una componente
conexa. El método todosArboles() devuelve un vértice que todavía no forma parte de
componente conexa, y el proceso termina cuando devuelve el valor clave –1.
El método que da entrada a los componentes del grafo: vértices y arcos, se deja como ejercicio
al lector.

Grafo:
![Image Alt](https://github.com/AugustoPaz13/TP7-Grafos/blob/b05bdc7dd6a6ce94f2a5249e32a21feed1f4426a/Grafo%2015.9.jpg)
