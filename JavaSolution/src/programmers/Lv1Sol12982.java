package programmers;

import java.util.Arrays;

public class Lv1Sol12982 {
    public static void main(String[] args) {

        int [] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(new Lv1Sol12982.Solution().solution(d, budget));
    }

    static class Solution {
        public int solution(int[] d, int budget) {
            var result = new Object() {
                int price = 0;
                int count = 0;
            };
            var arr = Arrays.stream(d).sorted().toArray();
            for (int item : arr) {
                if (result.price + item <= budget) {
                    result.price += item;
                    result.count++;
                } else {
                    break;
                }
            }
            return result.count;
        }
    }
}
