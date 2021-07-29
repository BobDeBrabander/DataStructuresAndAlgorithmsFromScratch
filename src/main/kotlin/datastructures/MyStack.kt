package datastructures

import java.util.EmptyStackException

/**
 * Technically this is also a sort of queue. A queue with the strategy LIFO.
 * Java implementation is Java.util.Stack
 * The proper queue implementation with strategy LIFO is Java.util.AsLIFOQueue.
 * This is because the Stack is implemented on the Vector class and not on the abstract Queue class.
 */
class MyStack<T: Any> : MyVector<T>() {

    fun pop(): T {
        if (this.isEmpty()) {
            throw EmptyStackException()
        }
        return removeLast()
    }

    fun push(element: T) {
        addElement(element)
    }

    fun isNotEmpty() = !this.isEmpty()

}
