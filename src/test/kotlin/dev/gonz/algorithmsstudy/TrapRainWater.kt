package dev.gonz.algorithmsstudy

import kotlin.math.max
import org.junit.jupiter.api.Test

class TrapRainWater {

    @Test
    fun wtf() {
        val list = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val list2 = intArrayOf(0, 2, 0, 3, 1, 0, 1, 3, 2, 1)
        trap(list2)
    }

    fun trap(heights: IntArray): Int {
        if (heights.isEmpty()) return 0

        var left = 0
        var right = heights.size - 1
        var leftMax = heights[left]
        var rightMax = heights[right]
        var res = 0
        while (left < right) {
            if (leftMax < rightMax) {
                left++
                leftMax = max(leftMax, heights[left])
                res += leftMax - heights[left]
            } else {
                right--
                rightMax = max(rightMax, heights[right])
                res += rightMax - heights[right]
            }
        }
        return res
    }
}