import java.util.ArrayList;
import java.util.List;

public class Pila<T> {
    private List<T> elementos;

    public Pila() {
        this.elementos = new ArrayList<>();
    }

    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    public T desapilar() {
        if (estaVacia()) {
            return null;
        }
        return elementos.remove(elementos.size() - 1);
    }

    public T cima() {
        if (estaVacia()) {
            return null;
        }
        return elementos.get(elementos.size() - 1);
    }

    public int getTamaño() {
        return elementos.size();
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public void mostrar() {
        System.out.println("Pila: " + elementos);
    }
}
