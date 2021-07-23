/**
 * Heap class done on Integers. It can be done on other objects as well. This would require to comparables.
 */
class MyMaxHeap : MyVector<Int>() {

    fun insertElement(element: Int){
        this.addElement(element)
        ensureMaxHeapProperty(elementCount-1)
    }

    fun extractMax() : Int {
        val maxVal = this[0]
        this[0] = this.lastElement()
        this.removeLast()
        maxHeapify(0)
        return maxVal
    }

    private fun parent(pos: Int) = ((pos+1) / 2) - 1
    private fun leftChild(pos: Int)  = (2 * (pos+1)) - 1
    private fun rightChild(pos: Int) = 2 * (pos+1)

    private fun ensureMaxHeapProperty(pos: Int){
        if(pos > 0 && this[parent(pos)] < this[pos]){
            swap(pos, parent(pos))
            ensureMaxHeapProperty(parent(pos))
        }
    }

    private fun maxHeapify(pos: Int){
        val left = leftChild(pos)
        val right = rightChild(pos)
        var largest = if (left < elementCount && this[left] > this[pos]) left else pos
        largest = if (right < elementCount && this[right] > this[largest]) right else largest
        if (largest != pos) {
            swap(largest, pos)
            maxHeapify(largest)
        }
    }

    private fun swap(pos1: Int, pos2: Int){
        val val1 = this[pos1]
        val val2 = this[pos2]
        this[pos2] = val1
        this[pos1] = val2
    }
}