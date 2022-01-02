package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Lv1Sol12973 {

    public static void main(String[] args) {
        System.out.println(new Lv1Sol12973.Solution().solution("baabaa"));
        System.out.println(new Lv1Sol12973.Solution().solution("cdcd"));
        System.out.println(new Lv1Sol12973.Solution().solution("baaba"));
    }
    static class Solution {
        public int solution(String s) {
            if (s.length() % 2 == 1) {
                return 0;
            }
            var stack = new Stack<Character>();
            int size = s.length();
            for (int i=0; i<size; i++) {
                char target = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(target);
                } else {
                    if (stack.peek() == target) {
                        stack.pop();
                    } else {
                        stack.push(target);
                    }
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
