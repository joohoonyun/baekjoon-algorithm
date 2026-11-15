class Solution {
    fun sortColors(nums: IntArray): Unit {
        quickSort(0, nums.size-1, nums)
    }

    fun quickSort(start: Int, end: Int, nums: IntArray) {
        // 탈출조건
        if (start >= end) return
        // pivot을 end로 잡고
        val pivot = nums[end]
        // smallerIdx를 start로 잡는다
        var smallerIdx = start

        // for문을 돌리면서 pivot 보다 작다면 순서를 바꾼다.
        for (curIdx in start until end) {
            if (pivot > nums[curIdx]) {
                swap(curIdx, smallerIdx, nums)
                smallerIdx++
            }
        }
        // Pivot을 최종 위치로 이동
        swap(smallerIdx, end, nums)

        // 재귀 
        quickSort(start, smallerIdx-1, nums)
        quickSort(smallerIdx+1, end, nums)
    } 

    fun swap(a: Int, b: Int, nums: IntArray) {
        var temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }
}