public class ArbolBinario<T extends Comparable<T>> {
    private Nodo<T> raiz;

    private static class Nodo<T> {
        T dato;
        Nodo<T> izquierda;
        Nodo<T> derecha;

        Nodo(T dato) {
            this.dato = dato;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo<T> insertarRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return new Nodo<>(dato);
        }

        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.derecha = insertarRecursivo(nodo.derecha, dato);
        }

        return nodo;
    }

    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return false;
        }

        if (dato.compareTo(nodo.dato) == 0) {
            return true;
        } else if (dato.compareTo(nodo.dato) < 0) {
            return buscarRecursivo(nodo.izquierda, dato);
        } else {
            return buscarRecursivo(nodo.derecha, dato);
        }
    }

    public void mostrarInOrden() {
        System.out.print("Inorden: ");
        mostrarInOrdenRecursivo(raiz);
        System.out.println();
    }

    private void mostrarInOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            mostrarInOrdenRecursivo(nodo.izquierda);
            System.out.print(nodo.dato + " ");
            mostrarInOrdenRecursivo(nodo.derecha);
        }
    }
}
