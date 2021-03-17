package programmers;

import java.util.stream.Stream;

public class Lv1Sol12916 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("yyYYzzpp"));
    }

    static class Solution {
        boolean solution(String s) {

            //0.03ms
            int countY = 0;
            int countP = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='y'||s.charAt(i)=='Y') {
                    countY++;
                } else if(s.charAt(i)=='p'||s.charAt(i)=='P') {
                    countP++;
                }
            }
            return countY == countP;

            //0.3 ms
//            int count_y = s.replaceAll("[^y|Y]","").length();
//            int count_p = s.replaceAll("[^p|P]","").length();
//
//            return count_y == count_p;
        }
    }
}
