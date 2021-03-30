package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol1018S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] SIZE = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] input = new int[SIZE[0]][SIZE[1]]; //입력된 체스판
        int[][] outputWhite = new int[8][8]; //0,0이 white 인 체스판
        int[][] outputBlack = new int[8][8]; //0,0이 black 인 체스판

        int whiteCnt = 0;
        int blackCnt = 0;
        for(int i=0; i<SIZE[0];i++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(s-> s.equals("W")?0:1).toArray();
            for(int k=0; k<SIZE[1];k++) {
                input[i][k] = line[k];
                if(i<8 && k<8) {
                    if((i+k)%2==0) {
                        outputWhite[i][k] = 0;
                        outputBlack[i][k] = 1;
                    } else {
                        outputWhite[i][k] = 1;
                        outputBlack[i][k] = 0;
                    }
                }
            }
        }
        int min = 9999999;
        int w = 0;
        int h = 0;
        while(true) {
            if(w==SIZE[1]-7) {
                h++;
                w=0;
            }
            if(h==SIZE[0]-7) {
                break;
            }
            for(int i=0; i<8;i++) {
                for(int j=0;j<8;j++) {
                    if(input[i+h][j+w] != outputWhite[i][j]) {
                        whiteCnt++;
                    }
                    if(input[i+h][j+w] != outputBlack[i][j]) {
                        blackCnt++;
                    }
                }
            }
            min = Math.min(min,Math.min(whiteCnt,blackCnt));
            whiteCnt = 0;
            blackCnt = 0;
            w++;
        }

        System.out.println("result:"+min);
    }

    static void print2Array(int[][] array) {
        for(int[] arr : array) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("-------------------");
    }
}
