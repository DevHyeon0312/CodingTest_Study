package Algo_Bookmark;

import java.util.Arrays;

public class ArrayLotation {

    /** X*Y 배열에 1부터 채워넣기 */
    static public int[][] createArray(int width, int height) {
        int[][] array = new int[height][width];
        int value = 1;
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                array[i][j] = value++;
            }
        }
        return array;
    }
    /** 1차원 배열 출력하기 */
    static public void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    /** 2차원 배열 출력하기 */
    static public void printArray(int[][] array) {
        for (int i=0; i<array.length;i++) {
            for (int j=0; j<array[0].length;j++) {
                System.out.printf("%02d ",array[i][j]);
            }
            System.out.println("");
        }
    }

    /** M*N 배열 외곽을 반시계방향으로 회전 : 2차원 배열은 얕은 복사라서 원본 자체를 고침 */
    static public void LotationArrayLeft(int[][] arr, int[] startIndex, int[] endIndex) {
        int x1 = startIndex[0];
        int y1 = startIndex[1];
        int x2 = endIndex[0];
        int y2 = endIndex[1];

        int start = arr[x1][y1];
        //[x1,y1] ~ [x1,y2] : 상
        for (int i=y1;i<y2;i++) {
            arr[x1][i] = arr[x1][i+1];
        }
        //[x1,y2] ~ [x2,y2] : 우
        for (int i=x1;i<x2;i++) {
            arr[i][y2] = arr[i+1][y2];
        }
        //[x2,y2] ~ [x2,y1] : 하
        for (int i=y2; i>y1; i--) {
            arr[x2][i] = arr[x2][i-1];
        }
        //[x2,y1] ~ [x1,y1] : 좌
        for (int i=x2; i>(x1+1); i--) {
            arr[i][y1] = arr[i-1][y1];
        }
        arr[x1+1][y1] = start;
    }
}
