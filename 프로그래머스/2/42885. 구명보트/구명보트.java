import java.util.Arrays;

class Solution {
     public int solution(int[] people, int limit) {
         int answer=0;
         
         Arrays.sort(people); // 50, 50, 70, 80
         
         int length = people.length - 1;
         int index = 0;
         
         while (index <= length) {
             if (people[index] + people[length] <= limit) index++;
             length--;
             answer++;
         }
         return answer;
     }
}