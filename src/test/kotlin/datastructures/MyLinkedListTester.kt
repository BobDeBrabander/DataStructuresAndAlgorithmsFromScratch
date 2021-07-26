package datastructures

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class MyLinkedListTester {

    @Test
    fun `constructing linkedList of collection works`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        assertEquals(5, myLinkedList.getSize(), "size is incorrect")
    }

    @Test
    fun `isNotEmpty works`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        assertTrue(myLinkedList.isNotEmpty(), "was not supposed to be empty")
    }

    @Test
    fun `constructing linkedList with default constructor works`(){
        val myLinkedList = MyLinkedList<Int>()
        assertEquals(0, myLinkedList.getSize(), "size is incorrect")
    }

    @Test
    fun `isEmpty works`(){
        val myLinkedList = MyLinkedList<Int>()
        assertTrue(myLinkedList.isEmpty(), "was supposed to be empty")
    }

    @Test
    fun `adding to linkedlist works`(){
        val myLinkedList = MyLinkedList<Int>()
        assertEquals(0, myLinkedList.getSize(), "size is incorrect")
        myLinkedList.add(1)
        myLinkedList.add(2)
        myLinkedList.add(3)
        myLinkedList.add(4)
        myLinkedList.add(5)
        assertEquals(5, myLinkedList.getSize(), "size is incorrect")
    }

    @Test
    fun `removeFirst and removeLast work`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        assertEquals(1, myLinkedList.removeFirst(), "first node incorrect")
        assertEquals(2, myLinkedList.removeFirst(), "first node incorrect")
        assertEquals(5, myLinkedList.removeLast(), "last node incorrect")
        assertEquals(4, myLinkedList.removeLast(), "last node incorrect")
        assertEquals(3, myLinkedList.removeFirst(), "first node incorrect")
        assertFailsWith(NoSuchElementException::class, "should have failed as list should be empty"){
            myLinkedList.removeFirst()
        }
    }

    @Test
    fun `getFirst and getLast work`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        assertEquals(1, myLinkedList.getFirst(), "first node incorrect")
        assertEquals(1, myLinkedList.getFirst(), "first node got removed?")
        assertEquals(5, myLinkedList.getLast(), "last node incorrect")
        assertEquals(5, myLinkedList.getLast(), "last node got removed?")
    }

    @Test
    fun `addFirst and addLast work`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        myLinkedList.addFirst(14)
        myLinkedList.addLast(64)
        assertEquals(14, myLinkedList.getFirst(), "first node incorrect")
        assertEquals(64, myLinkedList.getLast(), "last node incorrect")
    }

    @Test
    fun `getNodeAt works`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        val node = myLinkedList.getNodeAt(3)
        assertEquals(3, node.prev?.value, "we did not find the correct node")
        assertEquals(5, node.next?.value, "we did not find the correct node")
    }

    @Test
    fun `linkBefore works`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        val node = myLinkedList.getNodeAt(4)
        myLinkedList.linkBefore(7, node)
        assertEquals(5, myLinkedList.removeLast(), "last node incorrect")
        assertEquals(7, myLinkedList.removeLast(), "last node incorrect")
    }

    @Test
    fun `remove works`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        myLinkedList.remove(5)
        assertEquals(4, myLinkedList.getLast(), "last node incorrect")
    }

    @Test
    fun `toList works`(){
        val myLinkedList = MyLinkedList(listOf(1, 2, 3, 4, 5))
        assertEquals(listOf(1, 2, 3, 4, 5), myLinkedList.toList(), "toList not working correctly")
    }
}