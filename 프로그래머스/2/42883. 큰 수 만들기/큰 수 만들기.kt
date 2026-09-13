import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        val q: Deque<Char> = ArrayDeque()
        var limit: Int = k
        val length: Int = number.length
        
        for (i: Int in 0 until length) {
            while (limit > 0 && q.isNotEmpty() && q.peekLast() < number[i]) {
                limit--
                q.pollLast()
            }
            q.addLast(number[i])
        }
        
        // limit이 0이 아니면 q에 남아있는것들 중 마지막 것들을 뺀다.
        // 예를 들면 9432 -> 면 결국 앞에것이 뒤에것보다 계속해서 크기때문에 마지막 문자열을 뺴는것이 가장 큰수를 만드는 방법이다.
        
        while (limit > 0) {
            limit--
            q.pollLast()
        }
        
        // 문자열 조립
        val sb = StringBuilder()
        for (c: Char in q) {
            sb.append(c)
        }
        
        return sb.toString()
    }
}