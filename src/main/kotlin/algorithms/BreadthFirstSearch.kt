package algorithms

import datastructures.MyDeque
import datastructures.MyGraph
import datastructures.MyGraphNode

object BreadthFirstSearch {

    fun MyGraph.bfs(source: MyGraphNode, target: MyGraphNode): Int {
        val queue = MyDeque<MyGraphNode>(this.edges.size)
        source.dist = 0
        source.visited = true
        queue.offer(source)
        while (queue.isNotEmpty()) {
            val node = queue.pop()
            if (node == target) return node.dist
            node.adj.filterNot { it.target.visited }
                    .forEach {
                        it.target.dist = node.dist + 1
                        it.target.visited = true
                        it.target.parentInPath = node
                        queue.offer(it.target)
                    }
        }
        return -1
    }
}