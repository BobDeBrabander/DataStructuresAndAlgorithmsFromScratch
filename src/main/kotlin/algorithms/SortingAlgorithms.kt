package algorithms

import datastructures.MyMaxHeap

object SortingAlgorithms {

    fun heapSort(inputList: List<Int>) : List<Int>{
        val heap = MyMaxHeap(inputList)
        val resultList = mutableListOf<Int>()
        while(!heap.isEmpty()){
            resultList.add(heap.extractMax())
        }
        return resultList.toList()
    }
}