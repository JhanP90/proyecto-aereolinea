import java.util.ArrayList;
import java.util.List;

public class Cola<T> {
    private List<T> elementos;

    public Cola() {
        this.elementos = new ArrayList<>();
    }

    public void encolar(T elemento) {
        elementos.add(elemento);
    }

    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        return elementos.remove(0);
    }

    public T frente() {
        if (estaVacia()) {
            return null;
        }
        return elementos.get(0);
    }

    public int getTamaño() {
        return elementos.size();
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public void mostrar() {
        System.out.println("Cola: " + elementos);
    }
}
