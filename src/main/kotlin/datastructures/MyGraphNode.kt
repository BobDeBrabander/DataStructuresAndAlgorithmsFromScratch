package datastructures

class MyGraphNode (val identifier: Int? = null){
    var visited = false
    var dist : Int = -1
    var parentInPath: MyGraphNode? = null
    val inc = mutableListOf<MyEdge>()
    val adj = mutableListOf<MyEdge>()
    fun hasOutEdge(otherNode: MyGraphNode) = this.adj.map { it.target }.contains(otherNode)
    fun hasInEdge(otherNode: MyGraphNode) = this.inc.map { it.source }.contains(otherNode)
}