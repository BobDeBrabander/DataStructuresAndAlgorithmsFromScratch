package algorithms

object QuickSort {

    fun List<Int>.quickSort() = this.toMutableList().apply { this.quickSort(0, this.size - 1) }.toList()

    fun MutableList<Int>.quickSort(start: Int, end: Int) {
        if (start < end) {
            val q = this.partition(start, end)
            this.quickSort(start, q - 1)
            this.quickSort(q + 1, end)
        }
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