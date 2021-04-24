package programmers;

import java.util.stream.Stream;

public class Lv2Sol70129 {

    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            while(s.length() != 1) {
                answer[0]++;
                answer[1] += countZero(s);
                System.out.println(s);
                s = removeZero(s);
                System.out.println(s);
                s = IntToBinary(Long.parseLong(s));
            }
            return answer;
        }

        public int countZero(String s) {
            int count = 0;
            for(int i=0; i<s.length(); i++) {
                count = (s.charAt(i) == '0') ? count+1 : count;
            }
            return count;
        }

        public String removeZero(String s) {
            return s.replaceAll("0","");
        }


        public String IntToBinary(long number) {
            return Long.toBinaryString(number);
        }
    }
}
