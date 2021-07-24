package datastructures

import kotlin.IllegalStateException

class MyQueue (private val capacity: Int) {
    private var takeIndex : Int = 0
    private var pushIndex : Int = 0
    private var count : Int = 0
    private val elementData = arrayOfNulls<Int>(capacity)

    fun pop(): Int {
        if (count == 0) {
            throw NoSuchElementException()
        }
        return dequeue()
    }

    fun offer(element: Int) : Boolean{
        return if (count < capacity) {
            enqueue(element)
            true
        } else {
            false
        }
    }

    private fun enqueue(element: Int) {
        elementData[pushIndex++] = element
        if (pushIndex == capacity) pushIndex = 0
        count++
    }

    private fun dequeue() : Int {
        val returnVal = elementData[takeIndex]
        elementData[takeIndex++] = null
        if (takeIndex == capacity) takeIndex = 0
        count--
        return returnVal ?: throw IllegalStateException("Element was supposed to be non-null but was null")
    }

    fun isNotEmpty() : Boolean{
        return count > 0
    }

}