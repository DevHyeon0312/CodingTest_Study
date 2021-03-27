package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LvSol7453G2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[4][N];

        /** O(n) */
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            arr[2][i] = Integer.parseInt(st.nextToken());
            arr[3][i] = Integer.parseInt(st.nextToken());
        }

        int[] ARR1 = new int[N*N];
        int[] ARR2 = new int[N*N];

        /** O(n^2) */
        int index = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N;j++) {
                ARR1[index] = arr[0][i]+arr[1][j];
                ARR2[index++] = arr[2][i]+arr[3][j];
            }
        }

        Arrays.sort(ARR1); //ARR1 정렬
        Arrays.sort(ARR2); //ARR2 정렬


        long zero = 0; //합 0의 개수
        int Apoint = 0;
        int Bpoint = ARR2.length-1;
        long Acnt = 0; // Apoint 의 값이 동일한 횟수
        long Bcnt = 0; // Bpoint 의 값이 동일한 횟수
        while (true) {
            //각 포인트가 반대편으로 이동하면 break.
            if(Apoint > ARR1.length-1 || Bpoint < 0) {
                break;
            }
            //합이 0인 경우
            if((ARR1[Apoint] + ARR2[Bpoint]) == 0) {
                int A = ARR1[Apoint]; // 합 0인 순간의 A
                int B = ARR2[Bpoint]; // 합 0인 순간의 B
                //A 의 중복 개수 체크
                while(true) {
                    if(Apoint > ARR1.length-1 || A!=ARR1[Apoint]) {
                        break;
                    } else {
                        Apoint++;
                        Acnt++;
                    }
                }
                //B의 중복 개수 체크
                while(true) {
                    if(Bpoint < 0 || B!=ARR2[Bpoint]) {
                        break;
                    } else {
                        Bpoint--;
                        Bcnt++;
                    }
                }
                //합 0에 ADD
                zero += (Acnt * Bcnt);
                Acnt = 0;
                Bcnt = 0;
            }
            //합이 0보다 작은 경우 : A포인트를 오른쪽으로 옮길수록 합이 커짐
            else if((ARR1[Apoint] + ARR2[Bpoint]) <= 0) {
                Apoint++;
            }
            //합이 0보다 큰경우 : B포인트를 왼쪽으로 옮길수록 합이 작아짐.
            else {
                Bpoint--;
            }
        }
        System.out.println(zero);
    }
}