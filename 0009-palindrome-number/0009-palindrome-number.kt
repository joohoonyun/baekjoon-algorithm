class Solution {
    fun isPalindrome(x: Int): Boolean {
        // x / 10 을 하면 맨 오른쪽 수를 제거할 수 있다.
        // x % 10 을 하면 맨 오른쪽 수를 추출할 수 있다.
        // 음수는 palindrome이 될 수 없음
        // 0이 아닌 숫자가 0으로 끝나면 palindrome이 될 수 없음
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false
        }

        var num = x
        var revertedNumber = 0

        // 154321
        while (revertedNumber < num) {
            revertedNumber = revertedNumber * 10 + num % 10
            num /= 10
        }

        return num == revertedNumber || (num == revertedNumber/10)
    }
}