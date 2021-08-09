package datastructures

import exceptions.NotAllowedException

class MyTrieNode{
    val adj = MyHashMap<Char, MyTrieNode>()
    var isWordEnd : Boolean = false

    fun addCharacter(c: Char){
        val newNode = MyTrieNode()
        if (adj.containsKey(c)) throw NotAllowedException("This letter already exists")
        adj[c] = newNode
    }
}