import org.junit.Test
import kotlin.test.assertEquals

class MyMaxHeapTester {

    @Test
    fun `Basic MaxHeap test`(){
        val maxHeap = MyMaxHeap()
        maxHeap.insertElement(5)
        maxHeap.insertElement(12)
        maxHeap.insertElement(3)
        maxHeap.insertElement(18)
        maxHeap.insertElement(7)

        assertEquals(18, maxHeap.extractMax(), "Not expected max")
        assertEquals(12, maxHeap.extractMax(), "Not expected max")
        assertEquals(7, maxHeap.extractMax(), "Not expected max")
        assertEquals(5, maxHeap.extractMax(), "Not expected max")
        assertEquals(3, maxHeap.extractMax(), "Not expected max")
    }
}