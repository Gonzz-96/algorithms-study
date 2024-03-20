package dev.gonz.algorithmsstudy

data class Node(
    val value: Int,
    val neighbours: MutableList<Node> = mutableListOf(),
) {
    override fun toString(): String {
        return "$value"
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}

object SampleGraph {

    val root: Node

    init {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)

        node1.neighbours.addAll(listOf(node2, node4))
        node2.neighbours.addAll(listOf(node1, node3))
        node3.neighbours.addAll(listOf(node2, node4))
        node4.neighbours.addAll(listOf(node1, node3))

        root = node1
    }
}

fun cloneGraph(current: Node): Node {

    val oldToNew = hashMapOf<Node, Node>()

    fun dfs(node: Node): Node {
        if (node in oldToNew) {
            return oldToNew[node]!!
        }
        val copy = Node(node.value)
        oldToNew[node] = copy
        for (neighbour in node.neighbours) {
            copy.neighbours.add(dfs(neighbour))
        }
        return copy
    }

    return dfs(current)
}