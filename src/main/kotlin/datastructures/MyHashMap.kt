package datastructures

import java.lang.Double.min
import java.util.Objects

class MyHashMap<K : Any, V : Any> {

    private val DEFAULT_INITIAL_CAPACITY = 1 shl 4 // aka 16
    private val MAXIMUM_CAPACITY = 1 shl 29
    private val DEFAULT_LOAD_FACTOR = 0.75

    private var table: Array<Node<K, V>?>
    private var size: Int = 0
    private var threshold: Int
    private var loadFactor: Double

    constructor() {
        table = Array<Node<Any?, Any?>?>(DEFAULT_INITIAL_CAPACITY, { null }) as Array<Node<K, V>?>
        loadFactor = DEFAULT_LOAD_FACTOR
        threshold = min(DEFAULT_INITIAL_CAPACITY * loadFactor, MAXIMUM_CAPACITY.toDouble()).toInt()
    }

    constructor(initialCapacity: Int) {
        table = Array<Node<Any?, Any?>?>(initialCapacity, { null }) as Array<Node<K, V>?>
        loadFactor = DEFAULT_LOAD_FACTOR
        threshold = min(initialCapacity * loadFactor, MAXIMUM_CAPACITY.toDouble()).toInt()
    }

    constructor(initialCapacity: Int, loadFactor: Double) {
        table = Array<Node<Any?, Any?>?>(initialCapacity, { null }) as Array<Node<K, V>?>
        threshold = min(initialCapacity * loadFactor, MAXIMUM_CAPACITY.toDouble()).toInt()
        this.loadFactor = loadFactor
    }


    fun hash(key: Any): Int = (key.hashCode() and 0x7FFFFFFF) % table.size

    fun put(key: K, value: V) {
        if (size >= threshold) resize()
        val hash = hash(key)
        val index = hash % table.size
        val newNode = Node(hash, key, value, null)
        if (table[index] == null) {
            table[index] = newNode
        } else {
            var node = table[index]
            while (node?.next != null && node.key != key) node = node.next
            if (node?.key == key) {
                node.value = value
            } else {
                node?.next = newNode
            }
        }
        size++
    }

    operator fun set (key: K, value: V) = put(key, value)

    fun containsKey(key: K): Boolean {
        var node = table[hash(key)]
        while (node != null && node.key != key) node = node.next
        return node != null && node.key == key
    }

    operator fun get(key: K): V {
        var node = table[hash(key)]
        while (node != null && node.key != key) node = node.next
        return if (node != null && node.key == key) node.value
        else throw NoSuchElementException()
    }

    private fun resize() {
        val oldMap = table
        val oldCapacity = table.size

        var newCapacity = (oldCapacity shl 1) + 1
        if (newCapacity - MAXIMUM_CAPACITY > 0) {
            if (oldCapacity == MAXIMUM_CAPACITY) return
            newCapacity = MAXIMUM_CAPACITY
        }
        val newMap = Array<Node<Any?, Any?>?>(newCapacity, { null }) as Array<Node<K, V>?>
        threshold = min(newCapacity * loadFactor, MAXIMUM_CAPACITY.toDouble()).toInt()
        table = newMap
        size = 0 //The loop below will increment size again

        for (i in 0 until oldCapacity) {
            var node = oldMap[i]
            while (node != null) {
                put(node.key, node.value)
                node = node.next
            }
        }
    }

    fun getKeys(): List<K> {
        return getAllNodes().map { it.key }
    }

    fun getValues(): List<V> {
        return getAllNodes().map { it.value }
    }

    private fun getAllNodes(): List<Node<K, V>> {
        val nodes = mutableListOf<Node<K, V>>()
        for (element in table) {
            var node = element
            while (node != null) {
                nodes.add(node)
                node = node.next
            }
        }
        return nodes.toList()
    }

    fun remove(key: K): V {
        val index = hash(key)
        var node = table[index]
        var nodePrev: Node<K, V>? = null
        while (node != null && node.key != key) {
            nodePrev = node
            node = node.next
        }
        return if (node != null && node.key == key) {
            if (nodePrev == null) {
                table[index] = node.next
            } else {
                nodePrev.next = node.next
            }
            val returnVal = node.value
            node = null //for GC
            size--
            returnVal
        } else throw NoSuchElementException()
    }

    fun isEmpty() = size == 0
    fun getSize() = size
    fun getCapacity() = table.size


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