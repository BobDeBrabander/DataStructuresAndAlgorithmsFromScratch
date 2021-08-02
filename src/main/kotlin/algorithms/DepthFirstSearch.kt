package algorithms

import datastructures.MyDeque
import datastructures.MyGraph
import datastructures.MyNode
import datastructures.MyStack

object DepthFirstSearch {

    fun MyGraph.dfs(node: MyNode) {
        if (node.visited) return
        node.visited = true
        node.adj.map{it.target}.filter { !it.visited }.forEach { dfs(it) }
    }
}