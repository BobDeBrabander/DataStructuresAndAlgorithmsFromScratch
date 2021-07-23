import kotlin.math.max
import kotlin.math.min

open class MyVector <T: Any>{
    private var elementData : Array<Any?>
    var elementCount: Int = 0
    private val MAX_ARRAY_LENGTH = Int.Companion.MAX_VALUE - 8

    constructor(initialCapacity: Int = 10) {
        if (initialCapacity < 0) throw IllegalArgumentException("Can not initialize Vector with negative size")
        elementData = arrayOfNulls(initialCapacity)
    }

    constructor(c : Collection<T>){
        elementData = c.toTypedArray()
        elementCount = c.size
    }

    fun getSize() = elementCount

    fun getCapacity() = elementData.size

    fun toList() = elementData.slice(0 until elementCount).toList()

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
        elementData.copyInto(elementData, index+1, index, elementCount)
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
            elementData.copyInto(elementData, index, index+1, elementCount)
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

    fun addElements(elements: Collection<T>){
        ensureCapacity(elements.size)
        elements.forEach {
            elementData[elementCount] = it
            elementCount++
        }
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
     * Internal functions -----------------------------
     */

    /**
     * Will try to make at least `desiredEmptyCapacity` of space in `elementData`
     */
    private fun ensureCapacity(desiredEmptyCapacity: Int = 1){
        val emptyCapacity = elementData.size - elementCount
        if (desiredEmptyCapacity > emptyCapacity) grow(desiredEmptyCapacity - emptyCapacity)
    }

    /**
     * Will grow `elementData` to max(elementData.size * 2, elementData.size + desiredGrowth) with an upperBound of `MAX_ARRAY_LENGTH`
     */
    private fun grow(desiredGrowth: Int = 1){
        val desiredLength = max(elementData.size + desiredGrowth, elementData.size * 2)
        val newLength = min(desiredLength, MAX_ARRAY_LENGTH)
        elementData = elementData.copyOf(newLength)
    }

    private fun elementData(index: Int): T {
        return elementData[index] as T
    }

}