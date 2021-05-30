package programmers;

import java.util.Arrays;

public class Lv2Sol77885 {

    public static void main(String[] args) {
        long[] numbers = {2, 7};
        System.out.println(Arrays.toString(new Solution().solution(numbers)));
    }

    static class Solution {

        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            int i = 0;
            for (long l : numbers) {
                if (!Long.toBinaryString(l).contains("0")) {
                    String s = "1" + Long.toBinaryString(l).replaceFirst("1", "0");
                    answer[i] = Long.parseLong(s, 2);
                } else {
                    int index = Long.toBinaryString(l).lastIndexOf("0");
                    String s;
                    if (index == Long.toBinaryString(l).length() - 1) {
                        s = Long.toBinaryString(l).substring(0, index) + "1";
                    } else {
                        s = Long.toBinaryString(l).substring(0, index);
                        s += "10";
                        s += Long.toBinaryString(l).substring(index + 2);
                    }
                    answer[i] = Long.parseLong(s, 2);
                }
                i++;
            }

            return answer;
        }
    }
}
