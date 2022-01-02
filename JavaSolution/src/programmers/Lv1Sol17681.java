package programmers;

import java.util.Arrays;

public class Lv1Sol17681 {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        Arrays.stream(new Solution().solution(n, arr1, arr2)).forEach(
                System.out::println
        );


        int n2 = 6;
        int[] arr21 = {46, 33, 33 ,22, 31, 50};
        int[] arr22 = {27 ,56, 19, 14, 14, 10};
        Arrays.stream(new Solution().solution(n2, arr21, arr22)).forEach(
                System.out::println
        );
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for (int i=0; i<n; i++) {
                String[] binaryStr = binarySum(n, arr1[i],arr2[i]);
                answer[i] = changeString(binaryStr);
            }
            return answer;
        }

        public String[] binarySum(int n, int a, int b) {
            StringBuilder s = new StringBuilder(Integer.toBinaryString((a | b)));
            int size = s.length();
            if (size != n) {
                for (int i=0; i < n-size; i++) {
                    s = s.insert(0, "0");
                }
            }
            return s.toString().split("");
        }

        public String changeString(String[] binaryString) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : binaryString) {
                stringBuilder.append(s.equals("1") ? "#" : " ");
            }
            return stringBuilder.toString();
        }
    }
}
