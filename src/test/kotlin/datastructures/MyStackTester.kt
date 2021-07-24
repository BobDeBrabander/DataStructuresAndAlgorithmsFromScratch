package datastructures

import org.junit.Test
import java.util.EmptyStackException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MyStackTester {

    @Test
    fun `Stack should pop of the last inserted element`() {
        val stack = MyStack<Int>()
        val values = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        values.forEach { value ->
            stack.push(value)
        }
        val poppedValues = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            poppedValues.add(stack.pop())
        }
        assertEquals(
                values.reversed(),
                poppedValues.toList(),
                "Stack is not popping of the last inserted element"
        )
    }

    @Test
    fun `You can not pop when the stack is empty`(){
        val stack = MyStack<Int>()
        assertFailsWith(EmptyStackException::class,
                "empty stack should throw exception when trying to pop"
        ) { stack.pop() }
    }

}