package datastructures

import org.junit.Test
import kotlin.test.assertEquals

class MyMaxHeapTester {

    @Test
    fun `Inserting a series of elements and extracting them one by one`() {
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

    @Test
    fun `Inserting a lot of elements in one go, and extracting them one by one`() {
        val maxHeap = MyMaxHeap()
        maxHeap.insertElements(listOf(5, 12, 3, 18, 7))
        assertEquals(18, maxHeap.extractMax(), "Not expected max")
        assertEquals(12, maxHeap.extractMax(), "Not expected max")
        assertEquals(7, maxHeap.extractMax(), "Not expected max")
        assertEquals(5, maxHeap.extractMax(), "Not expected max")
        assertEquals(3, maxHeap.extractMax(), "Not expected max")
    }

    @Test
    fun `Constructing a maxHeap from a collection of elements, and extracting every element one by one`() {
        val maxHeap = MyMaxHeap(listOf(5, 12, 3, 18, 7))
        assertEquals(18, maxHeap.extractMax(), "Not expected max")
        assertEquals(12, maxHeap.extractMax(), "Not expected max")
        assertEquals(7, maxHeap.extractMax(), "Not expected max")
        assertEquals(5, maxHeap.extractMax(), "Not expected max")
        assertEquals(3, maxHeap.extractMax(), "Not expected max")
    }

    @Test
    fun `PeekMax works`() {
        val maxHeap = MyMaxHeap()
        maxHeap.insertElements(listOf(5, 12, 3, 18, 7))
        assertEquals(18, maxHeap.peekMax(), "Not expected max")
    }

    @Test
    fun `HeapSort works`() {
        val maxHeap = MyMaxHeap()
        maxHeap.insertElements(listOf(5, 12, 3, 18, 7, 21, 4, 95, 34, 2, 0, -6, 45))
        maxHeap.heapSort()
        assertEquals(
                listOf(-6, 0, 2, 3, 4, 5, 7, 12, 18, 21, 34, 45, 95),
                maxHeap.toList(),
                "MaxHeap not correctly sorted"
        )

    }
}