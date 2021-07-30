package datastructures

import kotlin.IllegalStateException

/**
 * Queue implementation with FIFO strategy, java implementation is Java.util.Deque
 */
class MyDeque <T: Any>(private val capacity: Int) {
    private var takeIndex : Int = 0
    private var pushIndex : Int = 0
    private var count : Int = 0
    private val elementData : Array<T?> = Array<Any?>(capacity, {null}) as Array<T?>

    fun pop(): T {
        if (count == 0) {
            throw NoSuchElementException()
        }
        return dequeue()
    }

    fun offer(element: T) : Boolean{
        return if (count < capacity) {
            enqueue(element)
            true
        } else {
            false
        }
    }

    private fun enqueue(element: T) {
        elementData[pushIndex++] = element
        if (pushIndex == capacity) pushIndex = 0
        count++
    }

    private fun dequeue() : T {
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