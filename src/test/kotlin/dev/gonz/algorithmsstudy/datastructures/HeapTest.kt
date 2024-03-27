package dev.gonz.algorithmsstudy.datastructures

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class HeapTest {

    lateinit var underTest: Heap
    private val testArray = intArrayOf(16, 4, 10, 14, 7, 9, 3, 2, 8, 1)

    @BeforeEach
    fun setUp() {
        underTest = HeapImpl(testArray)
    }

    @Test
    fun `heap returns the right parent`() {
        val result = underTest.parentOf(8)

        assertEquals(3, result)
    }

    @Test
    fun `heap returns the correct left node`() {
        val result = underTest.leftOf(2)

        assertEquals(5, result)
    }

    @Test
    fun `heap returns the correct right node`() {
        val result = underTest.rightOf(4)

        assertEquals(10, result)
    }

    @Test
    fun `maxHeapify returns a max-heap`() {
        // 'introduction to algorithms' initiates this procedure at the second item
        // since the root does comply to the max-heap property. It's the left subtree the
        // one not complying to this max-heap property.
        maxHeapify(underTest, 1)

        assertContentEquals(
            intArrayOf(16, 14, 10, 8, 7, 9, 3, 2, 4, 1),
            underTest.array,
        )
    }
}