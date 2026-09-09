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
                if (j == pattern.length - 1) {
                    return i - pattern.length + 1
                }
                j++
            }
        }
        return -1
    }

    fun pi(pattern: String): IntArray {
        var j: Int = 0;
        val pi: IntArray = IntArray(pattern.length) { 0 }
        for (i: Int in 1 until pi.size) {
            while (j>0 && pattern[i] != pattern[j]) {
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