package algorithms

object MergeSort {

    fun List<Int>.mergeSort(): List<Int> = this.toList().mergeSort(0, this.size - 1)

    private fun List<Int>.mergeSort(start: Int, end: Int): List<Int> {
        return when {
            start == end -> this
            start > end -> listOf()
            else -> {
                val mid = (start + end) / 2
                val part1 = this.subList(start, mid+1).mergeSort() //The endIndex on subList is exclusive
                val part2 = this.subList(mid+1, end+1).mergeSort()
                return merge(part1, part2)
            }
        }
    }

    /**
     * Takes 2 lists sorted in ascending order and adds them together such that they are still sorted in ascending order
     */
    private fun merge(list1: List<Int>, list2: List<Int>): List<Int> {
        var i1 = 0
        var i2 = 0
        val resultList = mutableListOf<Int>()
        while (i1 < list1.size || i2 < list2.size) {
            when {
                i1 >= list1.size -> {
                    resultList.addAll(list2.subList(i2, list2.size))
                    break
                }
                i2 >= list2.size -> {
                    resultList.addAll(list1.subList(i1, list1.size))
                    break
                }
                list1[i1] <= list2[i2] -> {
                    resultList.add(list1[i1])
                    i1++
                }
                else -> {
                    resultList.add(list2[i2])
                    i2++
                }
            }
        }
        return resultList.toList()
    }
}