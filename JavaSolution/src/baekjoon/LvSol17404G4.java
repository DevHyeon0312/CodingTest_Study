package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LvSol17404G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] paint = new int[n][3];

        int[][] selectR = new int[n][3];
        int[][] selectG = new int[n][3];
        int[][] selectB = new int[n][3];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            paint[i][0] = Integer.parseInt(st.nextToken());
            paint[i][1] = Integer.parseInt(st.nextToken());
            paint[i][2] = Integer.parseInt(st.nextToken());
        }

        //R 선택 케이스
        selectR[1][0] = 10000001;
        selectR[1][1] = paint[1][1]+paint[0][0];
        selectR[1][2] = paint[1][2]+paint[0][0];
        //G 선택 케이스
        selectG[1][0] = paint[1][0]+paint[0][1];
        selectG[1][1] = 10000001;
        selectG[1][2] = paint[1][2]+paint[0][1];
        //B 선택 케이스
        selectB[1][0] = paint[1][0]+paint[0][2];
        selectB[1][1] = paint[1][1]+paint[0][2];
        selectB[1][2] = 10000001;

        //고정선택 이후 계산
        for (int i=2; i<n;i++) {
            selectR[i][0] = Math.min(selectR[i-1][1], selectR[i-1][2]) + paint[i][0];
            selectR[i][1] = Math.min(selectR[i-1][0], selectR[i-1][2]) + paint[i][1];
            selectR[i][2] = Math.min(selectR[i-1][0], selectR[i-1][1]) + paint[i][2];

            selectG[i][0] = Math.min(selectG[i-1][1], selectG[i-1][2]) + paint[i][0];
            selectG[i][1] = Math.min(selectG[i-1][0], selectG[i-1][2]) + paint[i][1];
            selectG[i][2] = Math.min(selectG[i-1][0], selectG[i-1][1]) + paint[i][2];

            selectB[i][0] = Math.min(selectB[i-1][1], selectB[i-1][2]) + paint[i][0];
            selectB[i][1] = Math.min(selectB[i-1][0], selectB[i-1][2]) + paint[i][1];
            selectB[i][2] = Math.min(selectB[i-1][0], selectB[i-1][1]) + paint[i][2];
        }

        int R = Math.min(selectR[n-1][1],selectR[n-1][2]);   //R을 제외한 최소값
        int G = Math.min(selectG[n-1][0], selectG[n-1][2]);  //G을 제외한 최소값
        int B = Math.min(selectB[n-1][0], selectB[n-1][1]);  //B을 제외한 최소값

        //선택중 최소값 출력
        System.out.println(Math.min(Math.min(R,G),B));
    }
}
