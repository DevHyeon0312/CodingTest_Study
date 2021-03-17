package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1Sol42840 {

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(new Lv1Sol42840.Solution().solution(answers)));
    }

    static class Solution {
        public int[] solution(int[] answers) {
            int[] user1Sol = {1, 2, 3, 4, 5};
            int[] user2Sol = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] user3Sol = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int user1score = getScore(answers,user1Sol);
            int user2score = getScore(answers,user2Sol);
            int user3score = getScore(answers,user3Sol);
            int maxScore = Math.max(Math.max(user1score,user2score),user3score);
            ArrayList<Integer> list = new ArrayList<>();
            if(user1score == maxScore) {
                list.add(1);
            }
            if(user2score == maxScore) {
                list.add(2);
            }
            if(user3score == maxScore) {
                list.add(3);
            }

            return list.stream().mapToInt(i->i).toArray();
        }

        public int getScore(int[] answers, int[] userSol) {
            int score = 0;
            for (int i=0; i<answers.length; i++) {
                if (answers[i] == userSol[i%userSol.length]) {
                    score++;
                }
            }
            return score;
        }
    }
}
