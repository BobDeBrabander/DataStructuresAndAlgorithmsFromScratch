package algorithms

import algorithms.DepthFirstSearch.dfs
import datastructures.MyGraph
import datastructures.MyNode
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyDFSTester {

    private val graph = MyGraph()
    private val node1 = MyNode(1)
    private val node2 = MyNode(2)
    private val node3 = MyNode(3)
    private val node4 = MyNode(4)
    private val node5 = MyNode(5)
    private val node6 = MyNode(6)
    private val node7 = MyNode(7)
    private val node8 = MyNode(8)

    init {
        graph.addEdge(node1, node2)
        graph.addEdge(node2, node3)
        graph.addEdge(node3, node4)

        graph.addEdge(node5, node6)
        graph.addEdge(node6, node7)
        graph.addEdge(node7, node8)
    }

    @Before
    fun before(){
        graph.unvisitNodes()
    }

    @Test
    fun `if dfs on node1 you visit 1 till 4 but not 5 till 8`(){
        graph.dfs(node1)
        assertTrue(node1.visited)
        assertTrue(node2.visited)
        assertTrue(node3.visited)
        assertTrue(node4.visited)
        assertFalse(node5.visited)
        assertFalse(node6.visited)
        assertFalse(node7.visited)
        assertFalse(node8.visited)
    }

    @Test
    fun `if dfs on node5 you visit 5 till 8 but not 1 till 4`(){
        graph.dfs(node5)
        assertFalse(node1.visited)
        assertFalse(node2.visited)
        assertFalse(node3.visited)
        assertFalse(node4.visited)
        assertTrue(node5.visited)
        assertTrue(node6.visited)
        assertTrue(node7.visited)
        assertTrue(node8.visited)
    }

    @Test
    fun `if dfs on node6 you visit 6 till 8 but not 1 till 5`(){
        graph.dfs(node6)
        assertFalse(node1.visited)
        assertFalse(node2.visited)
        assertFalse(node3.visited)
        assertFalse(node4.visited)
        assertFalse(node5.visited)
        assertTrue(node6.visited)
        assertTrue(node7.visited)
        assertTrue(node8.visited)
    }
}