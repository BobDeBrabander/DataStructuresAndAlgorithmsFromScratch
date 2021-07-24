package datastructures

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse

class MyQueueTester {

    @Test
    fun `Inserting a series of elements and extracting them one by one`() {
        val queue = MyQueue(5)
        queue.offer(5)
        queue.offer(12)
        queue.offer(3)
        queue.offer(18)
        queue.offer(7)

        assertEquals(5, queue.pop(), "Not expected element")
        assertEquals(12, queue.pop(), "Not expected element")
        assertEquals(3, queue.pop(), "Not expected element")
        assertEquals(18, queue.pop(), "Not expected element")
        assertEquals(7, queue.pop(), "Not expected element")
    }


    @Test
    fun `Inserting and extracting more intertwined and fully looping around array`() {
        val queue = MyQueue(5)
        queue.offer(5)
        queue.offer(12)
        assertEquals(5, queue.pop(), "Not expected element")
        assertEquals(12, queue.pop(), "Not expected element")
        queue.offer(3)
        queue.offer(18)
        assertEquals(3, queue.pop(), "Not expected element")
        assertEquals(18, queue.pop(), "Not expected element")
        queue.offer(7)
        queue.offer(8)
        queue.offer(9)
        queue.offer(10)
        queue.offer(11)
        assertEquals(7, queue.pop(), "Not expected element")
        assertEquals(8, queue.pop(), "Not expected element")
        assertEquals(9, queue.pop(), "Not expected element")
        assertEquals(10, queue.pop(), "Not expected element")
        assertEquals(11, queue.pop(), "Not expected element")
    }

    @Test
    fun `Offering to full queue returns false`() {
        val queue = MyQueue(1)
        queue.offer(5)
        assertFalse(queue.offer(5), "Queue excepted element while it shouldn't have")
    }

    @Test
    fun `Trying to pop on an empty queue gives NoSuchElementException`() {
        val queue = MyQueue(1)
        assertFailsWith(NoSuchElementException::class, "Queue was empty and should have thrown exception"){
            queue.pop()
        }
    }
}