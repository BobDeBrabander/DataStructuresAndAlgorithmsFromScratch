package algorithms

import datastructures.MyGraph
import datastructures.MyGraphNode

object DepthFirstSearch {

    fun MyGraph.dfs(node: MyGraphNode) {
        if (node.visited) return
        node.visited = true
        node.adj.map{it.target}.filter { !it.visited }.forEach { dfs(it) }
    }
}