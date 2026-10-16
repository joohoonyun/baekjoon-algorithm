class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf<List<Int>>()
        val now: MutableList<Int> = mutableListOf<Int>()

        // 4C2
        combinations(1, n, k, result, now)
        return result
    }

    fun combinations(start: Int, n: Int, k: Int, result: MutableList<List<Int>>, current: MutableList<Int>) {
        if (current.size == k) {
            result.add(current.toList())
            return
        }

        for (i in start .. n) {
            current.add(i)
            combinations(i+1, n, k, result, current)
            current.removeAt(current.lastIndex)
        }
    }
}