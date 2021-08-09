package datastructures

import exceptions.NotAllowedException

class MyGraph {
    val nodes = mutableListOf<MyGraphNode>()
    val edges = mutableListOf<MyEdge>()

    fun addEdge(n1: MyGraphNode, n2: MyGraphNode, weight: Int = 1) {
        if (n1 == n2) throw NotAllowedException("Not allowed to create edge from a node to itself")
        if (edgeExists(n1, n2)) throw NotAllowedException("There already exists an edge from $n1 to $n2")
        val edge = MyEdge(n1, n2, weight)
        edges.add(edge)
        n1.adj.add(edge)
        n2.inc.add(edge)
    }

    fun edgeExists(n1: MyGraphNode, n2: MyGraphNode) = this.edges.any{it.source == n1 && it.target == n2}

    fun removeEdge(edge: MyEdge){
        removeEdge(edge.target, edge.source)
    }

    fun removeEdge(n1: MyGraphNode, n2: MyGraphNode) {
        if (!edgeExists(n1, n2)) throw NoSuchElementException("No edge exists from $n1 to $n2")
        edges.removeIf { it.source == n1 && it.target == n2 }
        n1.adj.removeIf { it.target == n2 }
        n2.inc.removeIf { it.target == n1 }
    }

    fun removeNode(node: MyGraphNode){
        val edgesToRemove = node.inc + node.adj
        edgesToRemove.forEach { removeEdge(it) }
        nodes.removeIf { it == node }
    }

    fun unvisitNodes(){
        nodes.forEach {
            it.visited = false
            it.dist = -1
        }
    }

}