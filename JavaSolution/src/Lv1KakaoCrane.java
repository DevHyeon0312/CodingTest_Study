import java.util.ArrayList;
import java.util.Stack;

/** Created By DevHyeon on 2020.11.18
 *  Question Title : 크레인 인형뽑기 게임
 *  Algorithm Type : Stack
 *  Level : 1
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/64061
 * */
class Lv1KakaoCrane {
    public static Stack resultStack;
    public static ArrayList<Stack> boardStack;

    public int solution(int[][] board, int[] moves) {
        resultStack = new Stack();
        boardStack = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            boardStack.add(new Stack());
        }

        for(int i=board.length-1; i>=0; i--) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] != 0) {
                    boardStack.get(j).add(board[i][j]);
                }
            }
        }

        int count = Move(board,moves);
        return count;
    }


    public int Move(int[][] board, int[] moves) {
        int count = 0;
        for(int i=0; i<moves.length; i++) {
            if(boardStack.get(moves[i]-1).size() == 0) {
                continue;
            }
            if(resultStack.size() == 0) {
                resultStack.push(boardStack.get(moves[i]-1).pop());
            }else {
                if(resultStack.peek() == boardStack.get(moves[i]-1).peek()) {
                    resultStack.pop();
                    boardStack.get(moves[i]-1).pop();
                    count+=2;
                }else {
                    resultStack.push(boardStack.get(moves[i]-1).pop());
                }
            }
        }

        return count;
    }
}