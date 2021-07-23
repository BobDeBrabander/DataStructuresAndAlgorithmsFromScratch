import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class MyVectorTester {

    @Test
    fun `Vector initialized with correct size if constructed from collection`() {
        val vector = MyVector(listOf(1, 2))
        val size = vector.getSize()
        assertEquals(2, size, "Wrong size returned")
    }

    @Test
    fun `Vector can be initialized with size 0`() {
        val vector = MyVector<Int>(0)
        val size = vector.getSize()
        assertEquals(0, size, "Wrong size returned")
    }

    @Test
    fun `Vector can not be initialized with negative size`() {
        assertFailsWith(IllegalArgumentException::class, "Vector got initialized with negative size and did not fail") {
            MyVector<Int>(-5)
        }
    }

    @Test
    fun `Vector initialized with empty constructor and manually filled returns correct size`() {
        val vector = MyVector<Int>()
        assertEquals(0, vector.getSize(), "Wrong size returned")
        vector.addElement(10)
        assertEquals(1, vector.getSize(), "Wrong size returned")
        vector.addElement(5)
        assertEquals(2, vector.getSize(), "Wrong size returned")
    }

    @Test
    fun `isEmpty function works`(){
        val vector = MyVector<Int>()
        assertTrue { vector.isEmpty() }
        val vector2 = MyVector<Int>(10)
        assertTrue { vector2.isEmpty() }
        val vector3 = MyVector<Int>(listOf())
        assertTrue { vector3.isEmpty() }
    }

    @Test
    fun `FirstElement works`() {
        val vector = MyVector(listOf(1, 2))
        assertEquals(1, vector.firstElement(), "firstElement not correct")
    }

    @Test
    fun `LastElement works`() {
        val vector = MyVector(listOf(1, 2))
        assertEquals(2, vector.lastElement(), "lastElement not correct")
    }

    @Test
    fun `AddElement works`() {
        val vector = MyVector<Int>(1)
        vector.addElement(1)
        val element = vector.get(0)
        assertEquals(1, element, "element is not correctly inserted into vector")
    }

    @Test
    fun `AddElements works`() {
        val vector = MyVector<Int>()
        vector.addElements(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13))
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13),
                vector.toList(),
                "elements not correctly inserted into vector")
    }

    @Test
    fun `Last element can be removed from vector`() {
        val vector = MyVector(listOf(1, 2))
        vector.removeLast()
        val element = vector.get(0)
        assertEquals(1, element, "Wrong element is removed")
    }

    @Test
    fun `First element can be removed from vector`() {
        val vector = MyVector(listOf(1, 2))
        vector.removeFirst()
        val element = vector.get(0)
        assertEquals(2, element, "Wrong element is removed")
    }

    @Test
    fun `Insert at position in the middle of array`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 5, 6))
        vector.insertElementAt(4, 4)
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6), vector.toList(), "Element insertion at index gone wrong")
    }

    @Test
    fun `Insert at works also on the index behind the last element`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 4, 5, 6))
        vector.insertElementAt(7, 7)
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7), vector.toList(), "Element insertion at index gone wrong")
    }

    @Test
    fun `Insert at works on index 0`(){
        val vector = MyVector(listOf(1, 2, 3, 4, 5, 6))
        vector.insertElementAt(0, 0)
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6), vector.toList(), "Element insertion at index gone wrong")
    }

    @Test
    fun `Insertion at index checks bounds`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 4, 5, 6))
        assertFailsWith(IndexOutOfBoundsException::class, "insertion was supposed to fail"){
            vector.insertElementAt(8, 8)
        }
    }

    @Test
    fun `You can remove element at position middle of the array`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 4, 4, 5, 6))
        vector.removeElementAt(4)
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6), vector.toList(), "Element removal at index gone wrong")
    }

    @Test
    fun `You can remove element at the last position array`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 4, 5, 6))
        vector.removeElementAt(6)
        assertEquals(listOf(0, 1, 2, 3, 4, 5), vector.toList(), "Element removal at index gone wrong")
    }

    @Test
    fun `RemoveLast works`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 4, 5, 6))
        vector.removeLast()
        assertEquals(listOf(0, 1, 2, 3, 4, 5), vector.toList(), "Element removal at index gone wrong")
    }

    @Test
    fun `You can remove element at index 0 of array`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 4, 5, 6))
        vector.removeElementAt(0)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), vector.toList(), "Element removal at index gone wrong")
    }

    @Test
    fun `RemoveFirst works`(){
        val vector = MyVector(listOf(0, 1, 2, 3, 4, 5, 6))
        vector.removeFirst()
        assertEquals(listOf(1, 2, 3, 4, 5, 6), vector.toList(), "Element removal at index gone wrong")
    }

    @Test
    fun `SetElementAt works`(){
        val vector = MyVector(listOf(0, 1, 2, 4, 4, 5, 6))
        vector.set(3, 3)
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6), vector.toList(), "SetElementAt gone wrong")
    }

    @Test
    fun `toList works, null element not passed along`(){
        val vector = MyVector<Int>(10)
        vector.addElement(1)
        vector.addElement(2)
        vector.addElement(3)
        vector.addElement(4)
        assertEquals(listOf(1, 2, 3, 4), vector.toList(), "toList not working properly")
    }

    @Test
    fun `Vector grows capacity accordingly with single inserts`(){
        val vector = MyVector<Int>(1)
        vector.addElement(0)
        assertEquals(1, vector.getCapacity(), "Growing not working properly?")
        vector.addElement(1)
        assertEquals(2, vector.getCapacity(), "Growing not working properly?")
        vector.addElement(2)
        assertEquals(4, vector.getCapacity(), "Growing not working properly?")
        vector.addElement(3)
        assertEquals(4, vector.getCapacity(), "Growing not working properly?")
        vector.addElement(4)
        assertEquals(8, vector.getCapacity(), "Growing not working properly?")
        vector.addElement(5)
        assertEquals(8, vector.getCapacity(), "Growing not working properly?")
        vector.addElement(6)
        assertEquals(8, vector.getCapacity(), "Growing not working properly?")
        vector.addElement(7)
        assertEquals(8, vector.getCapacity(), "Growing not working properly?")
    }

    @Test
    fun `Grow works properly with AddElements calls`() {
        val vector = MyVector<Int>()
        assertEquals(10, vector.getCapacity(), "Default initial capacity changed?")
        vector.addElements(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13))
        assertEquals(20, vector.getCapacity(), "Growing not working properly?")
    }

    @Test
    fun `If growing to twice the capacity is more than the amount of elements added, then this is prefered`() {
        val vector = MyVector<Int>()
        assertEquals(10, vector.getCapacity(), "Default initial capacity changed?")
        vector.addElements(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
        assertEquals(20, vector.getCapacity(), "Growing not working properly?")
    }
}