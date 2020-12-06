package programmers;

import java.util.ArrayList;

/** Created By DevHyeon on 2020.12.05
 *  Question Title : 삼각 달팽이
 *  Algorithm Type : 구현
 *  Level : 2
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/68645
 * */
public class Lv2Sol68645 {
    public int[] solution(int n) {
        if (n == 1) {
            return new int[]{1};
        }

        //Create Array
        int[][] arr = new int[n][n];

        //Add Item
        int item = 1;

        //startRow
        int startRow = 0;
        int startCol = 0;

        int row = 0;
        int col = 0;

        int endRow = n;
        int endCol = n;

        while (true) {
            col = startCol;
            row = startRow;

            if (row >= endRow || col >= endCol) {
                break;
            }

            if (arr[row][col] != 0) {
                break;
            }

            for (;row<endRow; row++) {
                arr[row][col] = item++;
            }

            row--;
            col++;

            for (;col<endCol; col++) {
                arr[row][col] = item++;
            }

            for (;col>endCol; col++) {
                arr[row][col] = item++;
            }

            col--;

            while (true) {
                row--;
                col--;
                if (row < 0 || col < 0) {
                    break;
                }
                if (arr[row][col] != 0) {
                    startRow=row+2;
                    startCol=col+1;
                    break;
                } else {
                    arr[row][col] = item++;
                }
            }

            System.out.println(row+","+col);
            System.out.println(startRow+","+startCol);
        }



        //new Array
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.printf("%02d ",arr[i][j]);
                if (arr[i][j] != 0) {
                    answerList.add(arr[i][j]);
                }
            }
            System.out.println("");
        }

        //return
        int[] array = answerList.stream().mapToInt(i->i).toArray();
        return array;
    }
}
