package dev.gonz.algorithmsstudy

data class MaxSubArray(
    val startIndex: Int,
    val endIndex: Int,
    val sum: Int,
)

fun findMaxSubArray(array: IntArray, startIndex: Int = 0, endIndex: Int = array.size - 1): MaxSubArray {
    if (startIndex == endIndex) {
        return MaxSubArray(startIndex, endIndex, array[startIndex])
    }

    val middleIndex = (startIndex + endIndex) / 2
    val (leftLow, leftHigh, leftSum) = findMaxSubArray(array, startIndex, middleIndex)
    val (rightLow, rightHigh, rightSum) = findMaxSubArray(array, middleIndex+1, endIndex)
    val (crossLow, crossHigh, crossSum) = findMaxCrossingSubArray(array, startIndex, middleIndex, endIndex)

    if (leftSum >= rightSum && leftSum >= crossSum) return MaxSubArray(leftLow, leftHigh, leftSum)
    if (rightSum >= leftSum && rightSum >= crossSum) return MaxSubArray(rightLow, rightHigh, rightSum)
    return MaxSubArray(crossLow, crossHigh, crossSum)
}

private fun findMaxCrossingSubArray(array: IntArray, startIndex: Int, middleIndex: Int, endIndex: Int): MaxSubArray {
    var sum = 0

    var leftMaxSum = Int.MIN_VALUE
    var maxLeftIndex = middleIndex
    for (i in middleIndex downTo startIndex) {
        sum += array[i]
        if (sum > leftMaxSum) {
            leftMaxSum = sum
            maxLeftIndex = i
        }
    }

    sum = 0
    var rightMaxSum = Int.MIN_VALUE
    var maxRightIndex = middleIndex + 1
    for (i in (middleIndex + 1)..endIndex) {
        sum += array[i]
        if (sum > rightMaxSum) {
            rightMaxSum = sum
            maxRightIndex = i
        }
    }

    return MaxSubArray(maxLeftIndex, maxRightIndex, leftMaxSum + rightMaxSum)
}
