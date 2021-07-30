package algorithms

import algorithms.BreadthFirstSearch.bfs
import datastructures.MyGraph
import datastructures.MyNode
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class MyBFSTester {

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
        graph.addEdge(node4, node5)
        graph.addEdge(node5, node6)
        graph.addEdge(node6, node7)
        graph.addEdge(node7, node8)

        graph.addEdge(node2, node5)
        graph.addEdge(node6, node3)
        graph.addEdge(node3, node6)
        graph.addEdge(node8, node2)
        graph.addEdge(node4, node1)
        graph.addEdge(node1, node3)
        graph.addEdge(node5, node7)
        graph.addEdge(node7, node4)
    }

    @Before
    fun before(){
        graph.unvisitNodes()
    }

    @Test
    fun `simple shortest path from 1 to 8`(){
        val shortestPath = graph.bfs(node1, node8)
        assertEquals(4, shortestPath, "shortest path not correct") //1, 2, 5, 7, 8
        assertEquals(node7, node8.parentInPath)
        assertEquals(node5, node7.parentInPath)
        assertEquals(node2, node5.parentInPath)
        assertEquals(node1, node2.parentInPath)
    }
}