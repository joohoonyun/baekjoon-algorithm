class Solution {
    fun isPalindrome(x: Int): Boolean {
        // 음수이면 팰린드롬이 될수 없음 
        var num: Int = x
        if (num == 0) return true
        if (num < 0 || (num % 10 == 0)) return false
        var revertedNumber: Int = 0

        while (revertedNumber < num) {
            revertedNumber = revertedNumber * 10 + num % 10
            num /= 10
        }

        // num = 1, revertedNumber = 12

        return (revertedNumber/10) == num || revertedNumber == num
    }
}