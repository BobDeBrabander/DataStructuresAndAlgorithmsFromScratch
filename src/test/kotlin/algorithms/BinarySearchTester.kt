package algorithms

import algorithms.BinarySearch.binarySearch
import org.junit.Test
import kotlin.test.assertEquals

class BinarySearchTester {

    @Test
    fun `basic binary search test`(){
        val array = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toTypedArray()
        val indexFound = array.binarySearch(5)
        assertEquals(5, indexFound, "index found is not correct")
    }

    @Test
    fun `search end of array`(){
        val array = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toTypedArray()
        val indexFound = array.binarySearch(10)
        assertEquals(10, indexFound, "index found is not correct")
    }

    @Test
    fun `search start of array`(){
        val array = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toTypedArray()
        val indexFound = array.binarySearch(0)
        assertEquals(0, indexFound, "index found is not correct")
    }

    @Test
    fun `small array still works`(){
        val array = listOf(0, 1).toTypedArray()
        val indexFound = array.binarySearch(0)
        assertEquals(0, indexFound, "index found is not correct")
    }

    @Test
    fun `size 1 array still works`(){
        val array = listOf(0).toTypedArray()
        val indexFound = array.binarySearch(0)
        assertEquals(0, indexFound, "index found is not correct")
    }

    @Test
    fun `binary search returns -1 if element not found`(){
        val array = listOf(0, 1, 2, 3, 4, 6, 7, 8, 9, 10).toTypedArray()
        val indexFound = array.binarySearch(5)
        assertEquals(-1, indexFound, "element shouldn't have been found")
    }
}