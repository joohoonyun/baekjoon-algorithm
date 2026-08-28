import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char now : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < now) {
                stack.pollLast();
                k--;
            }

            stack.addLast(now);
        }

        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}