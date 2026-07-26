class Solution {
    fun sortColors(nums: IntArray): Unit {
        quickSort(0, nums.size-1, nums)
    }

    fun quickSort(start: Int, end: Int, target: IntArray): Unit {
        if (start >= end) return

        val pivotIdx = partition(start, end, target)
        
        quickSort(start, pivotIdx-1, target)
        quickSort(pivotIdx+1, end, target)
    }

    fun partition(start: Int, end: Int, target: IntArray): Int {
        val pivot: Int = target[end]
        var smallerIdx = start
        
        for (curIdx: Int in start until end) {
            if (pivot >= target[curIdx]) {
                swap(target, curIdx, smallerIdx)
                smallerIdx++
            }
        }
        // [0,0,2,1,1,2]

        swap(target, smallerIdx, end)
        return smallerIdx
    }

    fun swap(target: IntArray, a: Int, b: Int) {
        var temp = target[a]
        target[a] = target[b]
        target[b] = temp
    }
}