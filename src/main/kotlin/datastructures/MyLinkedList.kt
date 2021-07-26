package datastructures

import java.lang.IllegalStateException
import java.lang.IndexOutOfBoundsException

class MyLinkedList <T: Any?>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size : Int = 0

    constructor()
    constructor(values: Collection<T>){
        addAll(values)
    }

    class Node<T>(var value: T?){
        var prev: Node<T>? = null
        var next: Node<T>? = null
    }

    fun getFirst() : T?{
        return head?.value ?: throw NoSuchElementException()
    }
    fun getLast() : T?{
        return tail?.value ?: throw NoSuchElementException()
    }

    fun removeFirst() : T?{
        return head?.let { unlink(it) } ?: throw NoSuchElementException()
    }
    fun removeLast() : T?{
        return tail?.let { unlink(it) } ?: throw NoSuchElementException()
    }

    fun unlink(node: Node<T>) : T?{
        val returnVal = node.value
        when {
            //node is head
            node.prev == null -> {
                //last node
                if (node.next == null) {
                    head = null
                    tail = null
                } else {
                    node.next?.prev = null
                    head = node.next
                }
            }
            //node is tail
            node.next == null -> {
                //we already know node.prev != null
                node.prev?.next = null
                tail = node.prev
            }
            else -> {
                node.prev?.next = node.next
                node.next?.prev = node.prev
            }
        }
        node.next = null
        node.prev = null
        node.value = null //help the GC
        size--
        return returnVal
    }

    fun contains(value: T) : Boolean{
        if (head == null) return false
        var curNode = head
        do {
            if (curNode?.value == value) return true
            curNode = curNode?.next
        } while(curNode != null)
        return false
    }

    fun add(value: T) = linkLast(value)
    fun addFirst(value: T) = linkFirst(value)
    fun addLast(value: T) = linkLast(value)

    fun linkBefore(value: T, successor: Node<T>){
        if (successor.prev == null){
            linkFirst(value)
        } else {
            val newNode = Node(value)
            newNode.prev = successor.prev
            newNode.next = successor
            successor.prev = newNode
        }
    }
    fun addAll(values: Collection<T>) {
        values.forEach{ add(it) }
    }

    /**
     * Removes first occurrence of value given.
     * If not found returns false, otherwise returns true
     */
    fun remove(value: T) : Boolean{
        if (head == null) return false
        var curNode = head
        do {
            if (curNode?.value == value){
                curNode?.run { unlink(this) }
                return true
            }
            curNode = curNode?.next
        } while(curNode != null)
        return false
    }

    private fun linkFirst(value: T){
        val newNode = Node(value)
        newNode.next = head
        head?.prev = newNode
        head = newNode
        if (tail == null) tail = newNode
        size++
    }
    private fun linkLast(value: T){
        val newNode = Node(value)
        newNode.prev = tail
        tail?.next = newNode
        tail = newNode
        if (head == null) head = newNode
        size++
    }

    fun getSize() = size

    fun isEmpty() = size == 0
    fun isNotEmpty() = !isEmpty()

    fun getNodeAt(index: Int) : Node<T>{
        if (index !in 0 until size){
            throw IndexOutOfBoundsException("Index $index not in 0 until $size")
        } else {
            var curNode = head
            repeat(index){ curNode = curNode?.next }
            return curNode ?: throw IllegalStateException("Expected non-null node was null")
        }
    }

    fun toList(): List<T>{
        if (size == 0) return listOf()
        val resultList = mutableListOf<T>()
        var curNode = head
        do {
            curNode?.value?.run { resultList.add(this) }
            curNode = curNode?.next
        } while(curNode != null)
        return resultList.toList()
    }
}