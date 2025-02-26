package dev.gonz.algorithmsstudy

import org.junit.jupiter.api.Test
import java.io.File
import java.util.PriorityQueue
import java.util.ResourceBundle

class DijkstrasAlgorithm {

    @Test
    fun `testing PriorityQueue class`() {
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(10)
        priorityQueue.add(11)
        priorityQueue.add(-4)
        priorityQueue.add(100)
        priorityQueue.add(1_000_000)
        priorityQueue.add(-234)

        while (priorityQueue.isNotEmpty()) {
            println(priorityQueue.remove())
        }
    }

    @Test
    fun `testing with Nodes`() {
        val priorityQueue = PriorityQueue<Pair<Node, Int>> { n1, n2 ->
            when  {
                n1.second > n2.second -> 1
                n1.second == n2.second -> 0
                else -> -1
            }
        }

        priorityQueue.add(Pair(Node(10), 2))
        priorityQueue.add(Pair(Node(10), 20))
        priorityQueue.add(Pair(Node(10), 5))
        priorityQueue.add(Pair(Node(10), 1_000))
        priorityQueue.add(Pair(Node(10), 1))

        while (priorityQueue.isNotEmpty()) {
            println(priorityQueue.remove())
        }
    }


    fun readGraph(): List<Edge> {
        val file = File("src/test/resources/dijkstras_test_graph").bufferedReader()
        return file.readLines().map { line ->
            line.split(" ").let {
                Edge(it[0], it[1], it[2].toInt())
            }
        }.also {
            file.close()
        }
    }

    data class Edge(
        val src: String,
        val dst: String,
        val w: Int,
    )
}