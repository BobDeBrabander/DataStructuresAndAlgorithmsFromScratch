package algorithms

import algorithms.MergeSort.mergeSort
import algorithms.SortTestUtil.isSorted
import org.junit.Test
import kotlin.test.assertTrue

class MergeSortTester {

    @Test
    fun `small merge sort test`(){
        val listToSort = listOf(4, 1, 8)
        val resultList = listToSort.mergeSort()
        assertTrue(resultList.isSorted() && resultList.containsAll(listToSort), "list did not get properly sorted")
    }

    @Test
    fun `big merge sort test`(){
        val listToSort = listOf(4, 1, 8, 4, 5, 13, 12, 10, -6, -15, 3, 34, 26, 83, 7)
        val resultList = listToSort.mergeSort()
        assertTrue(resultList.isSorted(), "list did not get properly sorted")
    }
}