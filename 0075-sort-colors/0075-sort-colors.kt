class Solution {
    fun sortColors(nums: IntArray): Unit {
        quickSort(0, nums.size-1, nums)     
    }

    fun quickSort(start: Int, end: Int, nums: IntArray): Unit {
        if (start >= end) return
        val pivotIdx = partition(start, end, nums)
        
        quickSort(start, pivotIdx-1, nums)
        quickSort(pivotIdx+1, end, nums)
    }

    fun partition(start: Int, end: Int, nums: IntArray): Int {
        val pivot = nums[end]
        var smallerIdx = start
        for (curIdx: Int in start until end) {
            if (pivot >= nums[curIdx]) {
                swap(curIdx, smallerIdx, nums)
                smallerIdx++        
            }
        }

        swap(smallerIdx, end, nums)
        return smallerIdx
    }

    fun swap(a: Int, b: Int, target: IntArray) {
        var temp = target[a]
        target[a] = target[b]
        target[b] = temp
    }
}