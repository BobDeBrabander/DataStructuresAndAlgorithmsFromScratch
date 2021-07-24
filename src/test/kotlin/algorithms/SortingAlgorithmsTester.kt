package algorithms

import org.junit.Test
import kotlin.test.assertEquals

class SortingAlgorithmsTester {

    @Test
    fun `HeapSort works for list of elements`() {
        val inputList = listOf(5, 12, 3, 18, 7, 21, 4, 95, 34, 2, 0, -6, 45)
        val outputList = SortingAlgorithms.heapSort(inputList)
        assertEquals(
                listOf(95, 45, 34, 21, 18, 12, 7, 5, 4, 3, 2, 0, -6),
                outputList,
                "HeapSort did not work correctly"
        )
    }

    @Test
    fun `HeapSort works for list of 1 element`() {
        val inputList = listOf(5)
        val outputList = SortingAlgorithms.heapSort(inputList)
        assertEquals(
                listOf(5),
                outputList,
                "HeapSort did not work correctly"
        )
    }
}