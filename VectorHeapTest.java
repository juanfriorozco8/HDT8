import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase VectorHeap.
 * Verifica la inserción, eliminación, orden y estado del heap.
 */
public class VectorHeapTest {

    @Test
    public void testAddAndRemoveInOrder() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        heap.add(new Patient("Maria", "apendicitis", "A"));
        heap.add(new Patient("Carmen", "dolores de parto", "B"));
        heap.add(new Patient("Juan", "fractura", "C"));

        assertEquals("Maria", heap.remove().getName());
        assertEquals("Carmen", heap.remove().getName());
        assertEquals("Juan", heap.remove().getName());
    }

    @Test
    public void testIsEmpty() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());

        heap.add(new Patient("Lorenzo", "chikunguya", "E"));
        assertFalse(heap.isEmpty());

        heap.remove();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testPeekReturnsCorrectPatient() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        heap.add(new Patient("Ana", "fiebre", "B"));
        heap.add(new Patient("Luis", "dolor", "A"));

        assertEquals("Luis", heap.peek().getName());
    }

    @Test
    public void testRemoveSingleElement() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        heap.add(new Patient("Único", "resfriado leve", "D"));

        Patient removed = heap.remove();
        assertEquals("Único", removed.getName());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testSizeUpdatesCorrectly() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        assertEquals(0, heap.size());

        heap.add(new Patient("Uno", "tos", "C"));
        heap.add(new Patient("Dos", "fiebre", "B"));
        assertEquals(2, heap.size());

        heap.remove();
        assertEquals(1, heap.size());

        heap.remove();
        assertEquals(0, heap.size());
    }
}
