import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryMaxHeapTest {

    @Test
    public void testBinaryMinHeapInitialization() {
        int maxSize = 10;
        BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>(maxSize);
        
        assertNotNull(heap);
        assertEquals(0, heap.size());
        assertEquals(maxSize, heap.maxSize());
    }

    @Test
    public void testAddElement() {
        BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>(10);
        heap.add(5);
        
        assertEquals(1, heap.size());
        assertEquals(5, heap.getMin());
    }

    @Test
    public void testExtractMin() {
        BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>(10);
        heap.add(5);
        heap.add(3);
        heap.add(8);
        
        assertEquals(3, heap.extractMin());
        assertEquals(2, heap.size());
        assertEquals(5, heap.getMin());
    }

    @Test
    public void testIsEmpty() {
        BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>(10);
        
        assertTrue(heap.isEmpty());
        
        heap.add(5);
        
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testRemoveElement() {
        BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>(10);
        heap.add(5);
        heap.add(3);
        heap.add(8);
        
        assertEquals(3, heap.removeE(1));
        assertEquals(2, heap.size());
        assertEquals(5, heap.getMin());
    }
}