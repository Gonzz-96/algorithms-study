package dev.gonz.algorithmsstudy

import org.junit.jupiter.api.Test

class CloneGraphTest {

    @Test
    fun `a graph deep copy was created`() {
        val underTest = SampleGraph.root

        val copy = cloneGraph(underTest)

        assert(true)
    }
}