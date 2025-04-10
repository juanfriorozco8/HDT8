import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> {
    protected ArrayList<E> data;

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

    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    public E remove() {
        if (data.isEmpty()) return null;
        E minVal = data.get(0);
        data.set(0, data.remove(data.size() - 1));
        if (!data.isEmpty()) pushDownRoot(0);
        return minVal;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public E peek() {
        return data.get(0);
    }
}
