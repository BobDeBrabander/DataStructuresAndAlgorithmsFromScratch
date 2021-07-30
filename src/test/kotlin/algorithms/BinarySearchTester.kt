package algorithms

import org.junit.Test
import algorithms.BinarySearch.binarySearch
import kotlin.test.assertEquals

class BinarySearchTester {

    @Test
    fun `basic binary search test`(){
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val indexFound = list.binarySearch(5)
        assertEquals(5, indexFound, "index found is not correct")
    }

    @Test
    fun `search end of list`(){
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val indexFound = list.binarySearch(10)
        assertEquals(10, indexFound, "index found is not correct")
    }

    @Test
    fun `search start of list`(){
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val indexFound = list.binarySearch(0)
        assertEquals(0, indexFound, "index found is not correct")
    }

    @Test
    fun `small list still works`(){
        val list = listOf(0, 1)
        val indexFound = list.binarySearch(0)
        assertEquals(0, indexFound, "index found is not correct")
    }

    @Test
    fun `size 1 list still works`(){
        val list = listOf(0)
        val indexFound = list.binarySearch(0)
        assertEquals(0, indexFound, "index found is not correct")
    }

    @Test
    fun `binary search returns -1 if element not found`(){
        val list = listOf(0, 1, 2, 3, 4, 6, 7, 8, 9, 10)
        val indexFound = list.binarySearch(5)
        assertEquals(-1, indexFound, "element shouldn't have been found")
    }
}