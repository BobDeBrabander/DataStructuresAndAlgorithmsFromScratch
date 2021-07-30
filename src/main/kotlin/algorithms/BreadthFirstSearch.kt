package algorithms

import datastructures.MyDeque
import datastructures.MyGraph
import datastructures.MyNode
import datastructures.MyStack

object BreadthFirstSearch {

    fun MyGraph.bfs(source: MyNode, target: MyNode): Int {
        val queue = MyDeque<MyNode>(this.edges.size)
        queue.offer(source)
        while (queue.isNotEmpty()) {
            val node = queue.pop()
            if (node == target) return node.dist
            node.adj.filterNot { it.target.visited }
                    .forEach {
                        it.target.dist = node.dist + 1
                        queue.offer(it.target)
                    }
        }
        return -1
    }
}