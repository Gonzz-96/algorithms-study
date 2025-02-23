package dev.gonz.algorithmsstudy.datastructures

fun heapMaximum(A: Heap): Int {
    return A.array.first()
}

fun heapExtractMax(A: Heap): Int {
    if (A.heapSize < 1) {
        throw IllegalArgumentException()
    }
    val max = A.array[0]
    A.array[0] = A.array[A.heapSize-1]
    A.heapSize -= 1
    maxHeapify(A, 0)
    return max
}