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
        val node5 = Node(5)
        val node6 = Node(6)
        val node7 = Node(7)
        val node8 = Node(8)
        val node9 = Node(9)

        // Graph:
        // 1 - 2      7 - 8
        // |   |     /    /
        // 4 - 3 -- 6 -- 9
        //      \   |
        //        - 5
        node1.neighbours.addAll(listOf(node2, node4))
        node2.neighbours.addAll(listOf(node1, node3))
        node3.neighbours.addAll(listOf(node2, node4, node5, node6))
        node4.neighbours.addAll(listOf(node1, node3))
        node5.neighbours.addAll(listOf(node3, node6))
        node6.neighbours.addAll(listOf(node3, node5, node7, node9))
        node7.neighbours.addAll(listOf(node6, node8))
        node8.neighbours.addAll(listOf(node7, node9))
        node9.neighbours.addAll(listOf(node6, node8))

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