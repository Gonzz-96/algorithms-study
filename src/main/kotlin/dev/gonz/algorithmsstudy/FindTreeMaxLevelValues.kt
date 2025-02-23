package dev.gonz.algorithmsstudy

import kotlin.math.max

// Given a binary tree, return a list containig the greatest element
// of every level of the tree.
//         1
//        / \
//       2   3
//      /   / \
//     5   7   6
//
// Answer: [1, 3, 7]
//

data class TreeNode(
    val value: Int,
    val left: TreeNode? = null,
    val right: TreeNode? = null,
)

fun levelMax(root: TreeNode?): IntArray {

    val levels = hashMapOf<Int, IntArray>()

    fun bfs(node: Node?, level: Int = 0) {
        if (node == null) return
        var levelArray = levels.getOrPut(level, ::intArrayOf)
        levelArray += node.value
        levels[level] = levelArray
        bfs(node, level+1)
    }

    return levels.values.flatMap {
        listOf(it.max())
    }.toIntArray()
}