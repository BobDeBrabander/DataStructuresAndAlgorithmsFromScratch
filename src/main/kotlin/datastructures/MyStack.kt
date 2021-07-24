package datastructures

import java.util.EmptyStackException

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
