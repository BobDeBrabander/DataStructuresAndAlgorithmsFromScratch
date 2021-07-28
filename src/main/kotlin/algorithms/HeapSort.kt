package algorithms

import datastructures.MyMaxHeap

object HeapSort {

    fun heapSort(inputList: List<Int>) : List<Int>{
        val heap = MyMaxHeap(inputList)
        val resultList = mutableListOf<Int>()
        while(heap.isNotEmpty()){
            resultList.add(heap.extractMax())
        }
        return resultList.toList()
    }
}