package programmers;

public class Lv1Sol12912 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(-1,3));
//        System.out.println(new Solution().solution(100,200));

    }
    static class Solution {
        public long solution(int a, int b) {
            long answer = 0;

            //a 와 b 가 같은 경우
            if(a==b) {
                return a;
            }

            //a와 b가 대칭인 경우
            if(Math.abs(a) == Math.abs(b)) {
                return 0;
            }

            //a와 b의 대칭구간이 부분적으로 존재하는 경우 (min 이 반드시 음수여야 하고, 그 절대값이 max 보다 작아야함.)
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            if(min < 0 && (Math.abs(min) < max)) {
                min = Math.abs(min)+1;
            }

            while(min < max) {
                answer += (min++) + (max--);
            }
            if(min == max) {
                answer += min;
            }
            return answer;
        }
    }
}
