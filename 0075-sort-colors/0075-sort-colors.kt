class Solution {
    fun sortColors(nums: IntArray): Unit {
        quickSort(0, nums.size-1, nums)
    }

    fun quickSort(start: Int, end: Int, nums: IntArray): Unit {
        if (start > end) return
        val pivot: Int = getPartition(start, end, nums)

        quickSort(start, pivot-1, nums)
        quickSort(pivot+1, end, nums)
    }

    fun getPartition(start: Int, end: Int, nums: IntArray): Int {
        val pivot = nums[end]
        var smallerIdx = start

        for (curIdx: Int in start until end) {
            if (nums[curIdx] <= pivot) {
                swap(curIdx, smallerIdx, nums)
                smallerIdx++
            }
        }

        swap(smallerIdx, end, nums)
        return smallerIdx    
    }

    fun swap(a: Int, b: Int, nums: IntArray): Unit {
        var temp: Int = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }
}