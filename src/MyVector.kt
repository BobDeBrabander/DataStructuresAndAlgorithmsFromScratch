import jdk.internal.util.ArraysSupport.MAX_ARRAY_LENGTH
import kotlin.math.min

open class MyVector <T: Any>(initialCapacity: Int = 10){
    var elementData : Array<Any?> = arrayOfNulls(initialCapacity)
    var elementCount: Int = 0

    fun isEmpty() : Boolean {
        return this.elementCount == 0
    }

    fun insertElementAt(element: T, index: Int){
        if (index > elementCount) {
            throw ArrayIndexOutOfBoundsException(index
                    .toString() + " > " + elementCount)
        } else if (index < 0) {
            throw ArrayIndexOutOfBoundsException(index)
        }

        ensureCapacity()
        System.arraycopy(elementData, index,
        elementData, index+1,
        elementData.size - index)
        elementData[index] = element
        elementCount++
    }

    fun removeElementAt(index: Int) : T{
        if (index >= elementCount) {
            throw ArrayIndexOutOfBoundsException(index
                    .toString() + " >= " + elementCount)
        } else if (index < 0) {
            throw ArrayIndexOutOfBoundsException(index)
        }
        return if (index == elementCount - 1) removeLast()
        else {
            val data = elementData[elementCount-1]
            System.arraycopy(elementData, index + 1,
                    elementData, index,
                    elementData.size - index - 1)
            elementCount--
            data as T
        }
    }

    fun removeFirst() = removeElementAt(0)

    fun removeLast() : T{
        if (elementCount == 0) throw NoSuchElementException()
        val data = elementData[elementCount-1]
        elementData[elementCount-1] = null
        elementCount--
        return data as T
    }

    fun setElementAt(element: T, index: Int){
        if (index >= elementCount) {
            throw ArrayIndexOutOfBoundsException(index.toString() + " >= " + elementCount)
        }
        elementData[index] = element
    }

    fun getElementAt(index: Int) = elementData(index)

    fun addElement(element: T){
        ensureCapacity()
        elementData[elementCount] = element
        elementCount++
    }

    fun firstElement() : T {
        if (elementCount == 0) throw NoSuchElementException()
        return elementData(0)
    }

    fun lastElement() : T {
        if (elementCount == 0) throw NoSuchElementException()
        return elementData(elementCount - 1)
    }


    /**
     * Internal functions
     */
    private fun ensureCapacity(){
        if (elementCount == elementData.size) grow()
    }

    private fun grow(){
        val newLength = min(elementData.size * 2, MAX_ARRAY_LENGTH)
        elementData = elementData.copyOf(newLength)
    }

    private fun elementData(index: Int): T {
        return elementData[index] as T
    }

}