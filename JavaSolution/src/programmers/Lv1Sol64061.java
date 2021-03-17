package programmers;

import java.util.Stack;

public class Lv1Sol64061 {
    public static void main(String[] args) {
        int [][] borad = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = {1,5,3,5,1,2,1,4};
        System.out.println(new Solution().solution(borad, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            Stack<Integer> stack = new Stack<>();
            int answer = 0;
            for (int target : moves) {
                for(int x=0; x<board.length;x++) {
                    if (board[x][target-1] != 0) {
                        if(!stack.empty() && stack.peek() == board[x][target-1]) {
                            stack.pop();
                            answer+=2;
                        } else {
                            stack.push(board[x][target-1]);
                        }
                        board[x][target-1] = 0;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
