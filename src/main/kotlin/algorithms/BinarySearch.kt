package algorithms

object BinarySearch {

    /**
     * input: sorted array
     * toFind: some value to find in the array
     *
     * output: an index of the toFind if it is found, or -1 if it is not found
     */
    fun Array<Int>.binarySearch(toFind: Int) : Int {
        return this.binarySearch(0, this.size-1, toFind)
    }

    private fun Array<Int>.binarySearch(min: Int, max: Int, toFind: Int) : Int{
        if (min > max) return -1
        val mid = (min+max)/2
        return when {
            this[mid] == toFind -> mid
            this[mid] > toFind -> this.binarySearch(min, mid-1, toFind)
            else -> this.binarySearch(mid+1, max, toFind)
        }
    }
}