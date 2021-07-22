import java.util.*

class MyStack<T: Any> : Vector<T>() {

    fun pop(): T {
        if (this.isEmpty()) {
            throw EmptyStackException()
        }
        return removeFirst()
    }

    fun push(element: T) {
        addElement(element)
    }

}
