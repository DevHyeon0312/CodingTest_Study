package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lv2Sol68645 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int[] solution(int n) {
            int nowX = 0;
            int nowY = 0;
            int item = 1;
            int[][] triArray = new int[n][n];

            if(n==1) {
                int[] result = new int[1];
                result[0] = 1;
                return result;
            }else if(n==2) {
                int[] result = new int[3];
                result[0] = 1;
                result[1] = 2;
                result[2] = 3;
                return result;
            }else if(n==3) {
                int[] result = new int[6];
                result[0] = 1;
                result[1] = 2;
                result[2] = 6;
                result[3] = 3;
                result[4] = 4;
                result[5] = 5;
                return result;
            }

            /** 삼각달팽이 2차원 배열 완성시키기 */
            boolean isChange = true;
            triArray[0][0] = item++;
            while(true) {
                //3가지 경우중 단 하나도 삽입을 하지 못한경우 break
                if(!isChange) {
                    break;
                } else {
                    isChange = false;
                }

                //상 -> 하 로 삽입
                while(++nowY < n && triArray[nowY][nowX] == 0) {
                    triArray[nowY][nowX] = item++;
                    isChange = true;
                }
                nowY--;

                //좌 -> 우 로 삽입
                while(++nowX < n && triArray[nowY][nowX] == 0) {
                    triArray[nowY][nowX] = item++;
                    isChange = true;
                }
                nowX--;

                //우하 -> 좌상 로 삽입
                while(--nowX >= 0 && --nowY >= 0 && triArray[nowY][nowX] == 0) {
                    triArray[nowY][nowX] = item++;
                    isChange = true;
                }
                nowX++;
                nowY++;
            }

            Arr2Print(triArray,n,n);

            /** 2차원 배열을 1차원으로 변환 */
            List<Integer> arrayList = new ArrayList<>();
            for(int[] arr : triArray) {
                Arrays.stream(arr).filter(i -> i != 0).forEach(arrayList::add);
            }

            return arrayList.stream().mapToInt(i->i).toArray();
        }



        public void Arr2Print(int[][] array, int x, int y) {
            for(int i=0; i<x;i++) {
                for (int j=0; j<y; j++) {
                    System.out.print(array[i][j]+" ");
                }
                System.out.println("");
            }
        }
    }
}
