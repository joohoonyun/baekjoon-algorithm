class Solution {
    // Dutch National Flag 알고리즘 사용
    fun sortColors(nums: IntArray): Unit {
        var low: Int = 0
        var mid: Int = 0
        var high: Int = nums.size-1

        while (mid <= high) {
            when (nums[mid]) {
                0 -> {
                    swap(nums, low, mid)
                    low++
                    mid++
                }

                1 -> {
                    mid++
                }

                2 -> {
                    swap(nums, mid, high)
                    high--
                }
            }
        }
    }

    fun swap(nums: IntArray, a: Int, b: Int) {
        var temp = nums[a]

        nums[a] = nums[b]
        nums[b] = temp
    }
}