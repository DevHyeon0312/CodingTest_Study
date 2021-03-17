package programmers;

public class Lv1Sol68935 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(45));
    }
    static class Solution {
        public int solution(int n) {
            int answer = 0;

            answer = fun3to10(fun10to3toReverse(n));

            return answer;
        }

        public int fun3to10(String n) {
            return Integer.parseInt(n,3);
        }

        public String fun10to3toReverse(int n) {
            StringBuilder str = new StringBuilder();
            while(true) {
                int q = n%3;
                if(n<3) {
                    str.insert(0,n);
                    break;
                }else {
                    str.insert(0,q);
                    n = n/3;
                }
            }
            return str.reverse().toString();
        }
    }
}
