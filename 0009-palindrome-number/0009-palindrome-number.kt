class Solution {
    fun isPalindrome(x: Int): Boolean {
        val str: String = x.toString()
        
        val sb = StringBuilder()
        for (i: Int in str.length-1 downTo 0) {
            sb.append(str[i])
        }

        val last = sb.toString()

        return str.equals(last)
    }
}