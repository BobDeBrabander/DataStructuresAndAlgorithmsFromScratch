package datastructures

class MyTrie{
    val root = MyTrieNode()

    fun containsWord(word: String) : Boolean{
        val chars = word.toCharArray()
        var node = root
        chars.forEach {
            if (node.adj.containsKey(it)) node = node.adj[it]
            else return false
        }
        return node.isWordEnd
    }

    fun addWord(word: String) {
        val chars = word.toCharArray()
        var node = root
        chars.forEach {
            if (!node.adj.containsKey(it)) node.addCharacter(it)
            node = node.adj[it]
        }
        node.isWordEnd = true
    }
}