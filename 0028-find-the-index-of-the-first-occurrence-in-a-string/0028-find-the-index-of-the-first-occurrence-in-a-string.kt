class Solution {
    fun strStr(haystack: String, needle: String): Int {
        return KMP(haystack, needle)
    }

    fun KMP(text: String, pattern: String): Int {
        val pi: IntArray = pi(pattern)

        var j: Int = 0
        for (i: Int in 0 until text.length) {
            while (j>0 && text[i] != pattern[j]) {
                j = pi[j-1]
            }

            if (text[i] == pattern[j]) {
                // 패턴 발견
                if (j == pattern.length-1) {
                    return i - pattern.length + 1
                }
                j++
            }
        }
        return -1
    }

    fun pi(pattern: String): IntArray {
        val length: Int = pattern.length
        val pi = IntArray(length) { 0 }
        var j: Int = 0
        for (i: Int in 1 until length) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j-1]
            }

            if (pattern[i] == pattern[j]) {
                j++
                pi[i] = j
            }
        }        
        return pi
    }
}