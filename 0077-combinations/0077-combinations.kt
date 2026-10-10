class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        // 4 C 2
        val result: MutableList<List<Int>> = mutableListOf<List<Int>>()
        val current: MutableList<Int> = mutableListOf<Int>()

        backTracking(1, n, k, current, result)
        return result
    }

    fun backTracking(
            start: Int, 
            n: Int, 
            k: Int, 
            current: MutableList<Int>, 
            result: MutableList<List<Int>>
        ) {

        if (current.size == k) {
            result.add(current.toList())
            return 
        }

        for (i in start .. n) {
            current.add(i)
            backTracking(i+1, n, k, current, result)
            current.removeAt(current.lastIndex)
        }    
    }
}