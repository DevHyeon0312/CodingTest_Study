package programmers;

import java.util.Arrays;

public class Lv2Sol12905 {

    public static void main(String[] args) {
        int [][] board = {{0,1,1,1}, {1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(
                new Lv2Sol12905.Solution().solution(board)
        );
        int [][] board2 = {{0,0,1,1}, {1,1,1,1}};
        System.out.println(
                new Lv2Sol12905.Solution().solution(board2)
        );

        int [][] board3 = {{1,1,1}, {1,0,1},{1,1,1}};
        System.out.println(
                new Lv2Sol12905.Solution().solution(board3)
        );

        int [][] board4 = {
                {1,1,1,1,1,1},
                {1,1,0,1,1,1},
                {1,1,1,1,1,1},
                {1,1,0,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1}};
        System.out.println(
                new Lv2Sol12905.Solution().solution(board4)
        );
    }
    static class Solution {
        public int solution(int[][] board) {
            System.out.println("");
            int firstSize = board.length;
            int secondSize = board[0].length;
            int[][] dp = new int[firstSize][secondSize];
            int r = 0;

            for (int i=0; i<firstSize; i++) {
                for (int j=0; j<secondSize; j++) {
                    if (board[i][j] == 0) {
                        System.out.print(dp[i][j]+"  ");
                        continue;
                    }

                    if (i == 0) {
                        dp[i][j] = board[i][j];
                    }

                    if (j == 0) {
                        dp[i][j] = board[i][j];
                    }

                    if (i !=0 && j != 0) {
                        int top = dp[i-1][j];
                        int left = dp[i][j-1];
                        int leftTop = dp[i-1][j-1];
                        int min = Math.min(leftTop, Math.min(left, top));
                        dp[i][j] = min+1;
                    }

                    r = Math.max(r, dp[i][j]);
                    System.out.print(dp[i][j]+"  ");
                }
                System.out.println("");
            }
            return r*r;
        }
    }
}
