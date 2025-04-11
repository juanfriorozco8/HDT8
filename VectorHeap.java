import java.util.ArrayList;

/**
 * Implementación de una cola de prioridad
 * utilizando un Heap mínimo basado en un ArrayList.
 * 
 * @param <E> tipo de elementos que deben ser comparables.
 */
public class VectorHeap<E extends Comparable<E>> {
    protected ArrayList<E> data;

    // Metodo constructor: crea una cola de prioridad vacía.
    public VectorHeap() {
        data = new ArrayList<>();
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void percolateUp(int i) {
        while (i > 0 && data.get(i).compareTo(data.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void pushDownRoot(int i) {
        int heapSize = data.size();
        while (left(i) < heapSize) {
            int left = left(i);
            int right = right(i);
            int smallest = left;

            if (right < heapSize && data.get(right).compareTo(data.get(left)) < 0) {
                smallest = right;
            }

            if (data.get(i).compareTo(data.get(smallest)) <= 0) break;

            swap(i, smallest);
            i = smallest;
        }
    }

    /**
     * Inserta un nuevo elemento en la cola de prioridad.
     * @param value el elemento a insertar
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Elimina y retorna el elemento con mayor prioridad.
     * Maneja correctamente el caso donde hay un solo elemento.
     * 
     * @return el elemento con mayor prioridad
     */
    public E remove() {
        if (data.isEmpty()) return null;
        E minVal = data.get(0);

        if (data.size() == 1) {
            data.remove(0);
        } else {
            data.set(0, data.remove(data.size() - 1));
            pushDownRoot(0);
        }

        return minVal;
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * @return true si está vacía, false si tiene elementos
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Retorna el tamaño de la cola de prioridad.
     * @return número de elementos
     */
    public int size() {
        return data.size();
    }

    /**
     * Retorna el siguiente elemento a atender sin eliminarlo.
     * @return el elemento con mayor prioridad
     */
    public E peek() {
        return data.get(0);
    }
}
