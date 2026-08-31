import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        var limit = k
        val length: Int = number.length
        val stack: Deque<Char> = ArrayDeque()
        
        for (i: Int in 0 until length) {
            while (stack.isNotEmpty() && limit > 0 && number[i] > stack.peekLast()) {
                stack.pollLast()
                limit--;
            }
            
            stack.addLast(number[i])
        }
        
        while (limit > 0) {
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