package dev.gonz.algorithmsstudy

import org.junit.jupiter.api.Test

class CloneGraphTest {

    @Test
    fun `a graph deep copy was created`() {
        val underTest = SampleGraph.root

        // build copy with DFS
        val copy = cloneGraph(underTest)

        // check with BSF
        assert(bfsCheck(underTest, copy))
    }

    private fun bfsCheck(original: Node, copy: Node): Boolean {
        val originalQueue = ArrayDeque<Node>()
        val copyQueue = ArrayDeque<Node>()

        val visitedValues = hashSetOf<Int>()

        fun bfs(currentO: Node, currentC: Node): Boolean {
            if (currentO.value != currentC.value) {
                return false
            } else {
                visitedValues.add(currentO.value)
            }
            for (neighbourO in currentO.neighbours) {
                if (neighbourO !in originalQueue && neighbourO.value !in visitedValues) {
                    originalQueue.enqueue(neighbourO)
                }
            }
            for (neighbourC in currentC.neighbours) {
                if (neighbourC !in copyQueue && neighbourC.value !in visitedValues) {
                    copyQueue.enqueue(neighbourC)
                }
            }
            return if (originalQueue.isEmpty() && copyQueue.isEmpty()) {
                true
            } else {
                bfs(originalQueue.dequeue(), copyQueue.dequeue())
            }
        }

        return bfs(original, copy)
    }

    private fun ArrayDeque<Node>.enqueue(node: Node) = addLast(node)
    private fun ArrayDeque<Node>.dequeue() = removeFirst()
}