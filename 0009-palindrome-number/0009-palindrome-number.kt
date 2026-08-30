class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false
        var number = x
        var revertedNumber: Int = 0

        while (number > revertedNumber) {
            revertedNumber = revertedNumber * 10 + number % 10 // 1
            number /= 10 // 12
        }

        return revertedNumber == number || number == revertedNumber/10
    }
}