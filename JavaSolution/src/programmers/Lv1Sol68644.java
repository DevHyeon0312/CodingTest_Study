package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1Sol68644 {
    public static void main(String[] args) {
        int [] numbers = {1,5,3,5,1,2,1,4};
        System.out.println(Arrays.toString(new Solution().solution(numbers)));
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = {};
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i=0; i<numbers.length; i++) {
                for (int j=i+1; j<numbers.length; j++) {
                    arrayList.add(numbers[i] + numbers[j]);
                }
            }
            answer = arrayList.stream().distinct().sorted().mapToInt(i->i).toArray();
            return answer;
        }
    }
}
