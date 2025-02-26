package dev.gonz.algorithmsstudy

import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MaxSubArrayTest {

    @Test
    fun `test that max subarray is found`() {
        val underTest = intArrayOf(
            13, -3, -25, 20, -3, -16, -23,
            18, 20, -7, 12, // this is the max sub array (7 - 10, sum = 43)
            -5, -22, 15, -4, 7,
        )

        val result = findMaxSubArray(underTest)
        val list = underTest.toList().subList(result.startIndex, result.endIndex+1)

        assertEquals(
            actual = result,
            expected = MaxSubArray(7, 10, 43),
        )
        assertContentEquals(
            actual = list,
            expected = listOf(18, 20, -7, 12),
        )
    }
}