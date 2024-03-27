package dev.gonz.algorithmsstudy.datastructures

interface Heap {
    var heapSize: Int
    val array: IntArray

    fun parentOf(i: Int): Int
    fun leftOf(i: Int): Int
    fun rightOf(i: Int): Int
    fun exchange(i: Int, j: Int)
    operator fun get(i: Int): Int
}

class HeapImpl(
    override val array: IntArray = intArrayOf(),
) : Heap {

    override var heapSize = array.size

    override fun parentOf(i: Int) = (i - 1) / 2

    override fun leftOf(i: Int) = (2 * i) + 1

    override fun rightOf(i: Int) = (2 * i) + 2

    override fun exchange(i: Int, j: Int) {
        if (i < heapSize && j < heapSize) {
            val tempI = array[i]
            array[i] = array[j]
            array[j] = tempI
        }
    }

    override operator fun get(i: Int): Int =
        array[i]
}

// functions making a heap comply to the max-heap property
fun maxHeapify(A: Heap, index: Int) {
    val l = A.leftOf(index)
    val r = A.rightOf(index)

    var largest = if (l < A.heapSize && A[l] > A[index]) {
        l
    } else {
        index
    }

    if (r < A.heapSize && A[r] > A[largest]) {
        largest = r
    }

    if (largest != index) {
        A.exchange(index, largest)
        maxHeapify(A, largest)
    }
}

// function transforming an array to a heap
fun buildMaxHeap(A: Heap) {
    for (i in A.heapSize / 2 downTo 0) {
        maxHeapify(A, i)
    }
}

// function implementing heapsort
fun heapsort(A: Heap): IntArray {
    buildMaxHeap(A)
    for (i in (A.array.size - 1) downTo 1) {
        A.exchange(0, i)
        A.heapSize -= 1
        maxHeapify(A, 0)
    }
    return A.array
}