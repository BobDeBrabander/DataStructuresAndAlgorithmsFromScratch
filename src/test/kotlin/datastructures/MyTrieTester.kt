package datastructures

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyTrieTester {

    @Test
    fun `simple trie test`(){
        val trie = MyTrie()
        trie.addWord("kaas")
        trie.addWord("pizza")
        trie.addWord("bananen")

        assertTrue(trie.containsWord("kaas"))
        assertFalse(trie.containsWord("kaass"))
        assertFalse(trie.containsWord("kaa"))

        assertTrue(trie.containsWord("pizza"))
        assertFalse(trie.containsWord("pizz"))
        assertFalse(trie.containsWord("pizzaa"))

        assertTrue(trie.containsWord("bananen"))
        assertFalse(trie.containsWord("bananenn"))
        assertFalse(trie.containsWord("banane"))

        assertFalse(trie.containsWord(""))
        assertFalse(trie.containsWord("blabla"))
        assertFalse(trie.containsWord("hoi"))
    }
}