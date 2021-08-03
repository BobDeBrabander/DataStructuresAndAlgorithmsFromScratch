package datastructures

import java.util.Objects

class MyHashMap <K: Any, V: Any> {

    private val DEFAULT_INITIAL_CAPACITY = 1 shl 4 // aka 16
    private val MAXIMUM_CAPACITY = 1 shl 30
    private val DEFAULT_LOAD_FACTOR = 0.75

    var table : Array<Node<K, V>?>
    var size: Int = 0
    var threshold: Int
    var loadFactor: Double

    constructor(){
        table = Array<Node<Any?, Any?>?>(DEFAULT_INITIAL_CAPACITY, {null}) as Array<Node<K, V>?>
    }

    constructor(initialCapacity: Int){
        table = Array<Node<Any?, Any?>?>(initialCapacity, {null}) as Array<Node<K, V>?>
    }

    init {
        threshold = DEFAULT_INITIAL_CAPACITY
        loadFactor = DEFAULT_LOAD_FACTOR
    }

    fun hash(key: Any): Int = (key.hashCode() and 0x7FFFFFFF) % table.size

    fun put(key: K, value: V) = addEntry(hash(key), key, value)

    private fun addEntry(hash: Int, key: K, value: V){
        val index = hash % table.size
        val newNode = Node(hash, key, value, null)
        if (table[index] == null) {
            table[index] = newNode
        } else {
            var node = table[index]
            while(node?.next != null && node.key != key) node = node.next
            if (node?.key == key){
                node.value = value
            } else {
                node?.next = newNode
            }
        }
        size++
    }

    fun get(key: K) : V{
        val index = hash(key) % table.size
        var node = table[index]
        while (node != null && node.key != key) node = node.next
        return if (node != null && node.key == key) node.value
        else throw NoSuchElementException()
    }

    fun resize(){
        throw NotImplementedError()
    }

    /**
     * Node class copied from Java.Util.HashMap and converted into Kotlin
     */
    open class Node<K, V>(val hash: Int, override val key: K, override var value: V, var next: Node<K, V>?) : MutableMap.MutableEntry<K, V> {
        override fun toString(): String {
            return key.toString() + "=" + value
        }

        override fun hashCode(): Int {
            return Objects.hashCode(key) xor Objects.hashCode(value)
        }

        override fun setValue(newValue: V): V {
            val oldValue = value
            value = newValue
            return oldValue
        }

        override fun equals(other: Any?): Boolean {
            if (other === this) return true
            if (other is Map.Entry<*, *>) {
                val e = other
                if (key == e.key &&
                        value == e.value) return true
            }
            return false
        }
    }
}