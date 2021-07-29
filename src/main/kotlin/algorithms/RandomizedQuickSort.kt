package algorithms

import kotlin.random.Random.Default.nextInt

object RandomizedQuickSort {

    fun List<Int>.randomizedQuickSort() = this.toMutableList().apply { this.randomizedQuickSort(0, this.size - 1) }.toList()

    fun MutableList<Int>.randomizedQuickSort(start: Int, end: Int) {
        if (start < end) {
            val q = this.randomizedPartition(start, end)
            this.randomizedQuickSort(start, q - 1)
            this.randomizedQuickSort(q + 1, end)
        }
    }

    fun MutableList<Int>.randomizedPartition(start: Int, end: Int) : Int {
        val i = nextInt(start, end+1)
        this.swap(i, end)
        return this.partition(start, end)
    }

    fun MutableList<Int>.partition(start: Int, end: Int) : Int {
        val pivot = this[end]
        var i = start - 1
        for (j in start until end){
            if (this[j] <= pivot){
                i++
                this.swap(i, j)
            }
        }
        this.swap(i+1, end)
        return i+1
    }

    fun MutableList<Int>.swap(i1: Int, i2: Int) {
        if (i1 == i2) return
        val el1 = this[i1]
        this[i1] = this[i2]
        this[i2] = el1
    }
}