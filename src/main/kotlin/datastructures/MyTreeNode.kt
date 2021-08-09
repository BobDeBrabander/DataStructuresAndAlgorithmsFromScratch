package datastructures

import exceptions.NotAllowedException

class MyTreeNode<T: Any> (var parent: MyTreeNode<T>?, var data: T){
    var leftChild: MyTreeNode<T>? = null
    var rightChild: MyTreeNode<T>? = null

    fun addLeftChild(data: T){
        if (leftChild != null) throw NotAllowedException("Node already has left child")
        leftChild = MyTreeNode(this, data)
    }

    fun addRightChild(data: T){
        if (rightChild != null) throw NotAllowedException("Node already has right child")
        rightChild = MyTreeNode(this, data)
    }
}