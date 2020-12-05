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

        //startIndex
        int start = 0;

        //max
        int wMax = n-1;
        int hMax = n-1;

        //now
        int wNow = 0;
        int hNow = 0;

        int tW = 0;
        int tH = 0;

        boolean isMax = true;

        //arrItem
        int arrItem = arr[hNow][wNow];
        while (arrItem == 0) {
            System.out.println(wNow+","+hNow+"["+wMax+":"+hMax+"]");
            arr[hNow][wNow] = item++;

            if (hNow != hMax) {
                hNow++;
            }
            else if (wNow != wMax) {
                wNow++;
            }
            else {
                if (wNow -1 != start) {
                    wNow--;
                    hNow--;
                    wMax--;
                    hMax--;
                    if (isMax) {
                        tW = wMax;
                        tH = hMax;
                        isMax = false;
                    }
                } else {
                    start++;
                    wNow = start;
                    hNow = start+1;
                    isMax = true;
                    wMax = tW-1;
                    hMax = tH;
                }
            }

            arrItem = arr[hNow][wNow];
        }

        System.out.println(wNow+","+hNow+"["+wMax+":"+hMax+"]");
        System.out.println(arr[wNow][hNow]);



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
