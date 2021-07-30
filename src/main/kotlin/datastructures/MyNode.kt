package datastructures

class MyNode {
    var visited = false
    var dist : Int = -1
    val inc = mutableListOf<MyEdge>()
    val adj = mutableListOf<MyEdge>()
    fun hasOutEdge(otherNode: MyNode) = this.adj.map { it.target }.contains(otherNode)
    fun hasInEdge(otherNode: MyNode) = this.inc.map { it.source }.contains(otherNode)
}