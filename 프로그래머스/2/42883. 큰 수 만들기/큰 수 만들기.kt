import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        val stack: Deque<Char> = ArrayDeque()
        var limit: Int = k
        
        for (i: Int in 0 until number.length) {
            while (limit>0 && stack.isNotEmpty() && stack.peekLast() < number[i]) {
                stack.pollLast()
                limit--
            }
            stack.addLast(number[i])
        }
        
        
        while (limit>0) {
            stack.pollLast()
            limit--
        }
        
        
        val sb = StringBuilder()
        for (c in stack) {
            sb.append(c)
        }
        
        return sb.toString()
    }
}