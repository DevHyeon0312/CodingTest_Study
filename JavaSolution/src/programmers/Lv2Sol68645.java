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

        int min = 0;
        int max = n-1;
        int w = 0 , h = 0;

        boolean isMax = true;
        int breakPoint = n % 2 == 0 ? n/2 : n/2+1;

        while (true) {
            if (h == w && h != min) {
                if (h == max && isMax) {
                    max--;
                    isMax = false;
                }
                arr[h--][w--] = item++;
                continue;
            }

            if ( h != max) {
                arr[h++][w] = item++;
                min = w+1;
                isMax = true;
            } else {
                arr[h][w++] = item++;
            }

            if (w == breakPoint && h == breakPoint) {
                break;
            }
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
