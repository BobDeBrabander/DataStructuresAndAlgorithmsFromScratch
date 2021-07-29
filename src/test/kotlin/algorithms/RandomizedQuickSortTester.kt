package algorithms

import algorithms.RandomizedQuickSort.randomizedQuickSort
import algorithms.SortTestUtil.isSorted
import org.junit.Test
import kotlin.test.assertTrue

class RandomizedQuickSortTester {

    @Test
    fun `small quick sort test`(){
        val listToSort = listOf(4, 1, 8)
        val resultList = listToSort.randomizedQuickSort()
        assertTrue(resultList.isSorted() && resultList.containsAll(listToSort), "list did not get properly sorted")
    }

    @Test
    fun `single element quick sort test`(){
        val listToSort = listOf(4)
        val resultList = listToSort.randomizedQuickSort()
        assertTrue(resultList.isSorted() && resultList.containsAll(listToSort), "list did not get properly sorted")
    }

    @Test
    fun `big quick sort test`(){
        val listToSort = listOf(4, 1, 8, 4, 5, 13, 12, 10, -6, -15, 3, 34, 26, 83, 7)
        val resultList = listToSort.randomizedQuickSort()
        assertTrue(resultList.isSorted(), "list did not get properly sorted")
    }
}