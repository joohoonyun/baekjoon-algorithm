class Solution {
    fun solution(s: String): Int {
        var answer = 0
        
        for (i in s.indices) {
            answer = maxOf(answer, expand(s, i, i))
            answer = maxOf(answer, expand(s, i, i+1))
        }
        return answer
    }
    
    fun expand(s: String, left: Int, right: Int): Int {
        var leftValue = left
        var rightValue = right
        
        while (leftValue >= 0 && rightValue < s.length && 
                s[leftValue] == s[rightValue]) {
            leftValue--
            rightValue++
        }
        
        return rightValue - leftValue - 1
    }
}