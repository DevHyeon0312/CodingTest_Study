package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class LvSol17404G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        home[][] paint = new home[n][3];

        home[][] selectR = new home[n][3];
        home[][] selectG = new home[n][3];
        home[][] selectB = new home[n][3];

        for (int i=0; i<n; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            paint[i][0] = new home(0, input[0]);
            paint[i][1] = new home(1, input[1]);
            paint[i][2] = new home(2, input[2]);
        }

        selectR[0][0] = new home(0, paint[0][0].cost);
        selectR[0][1] = new home(0, paint[0][1].cost);
        selectR[0][2] = new home(0, paint[0][2].cost);
        selectR[1][0] = new home(0, 10000001);
        selectR[1][1] = new home(0, paint[1][1].cost+paint[0][0].cost);
        selectR[1][2] = new home(0, paint[1][2].cost+paint[0][0].cost);

        selectG[0][0] = new home(0, paint[0][0].cost);
        selectG[0][1] = new home(0, paint[0][1].cost);
        selectG[0][2] = new home(0, paint[0][2].cost);

        selectG[1][0] = new home(0, paint[1][0].cost+paint[0][1].cost);
        selectG[1][1] = new home(0, 10000001);
        selectG[1][2] = new home(0, paint[1][2].cost+paint[0][1].cost);

        selectB[0][0] = new home(0, paint[0][0].cost);
        selectB[0][1] = new home(0, paint[0][1].cost);
        selectB[0][2] = new home(0, paint[0][2].cost);

        selectB[1][0] = new home(0, paint[1][0].cost+paint[0][2].cost);
        selectB[1][1] = new home(0, paint[1][1].cost+paint[0][2].cost);
        selectB[1][2] = new home(0, 10000001);

        for (int i=2; i<n;i++) {
            selectR[i][0] = new home(min(selectR[i-1][1], selectR[i-1][2]).starthome, min(selectR[i-1][1], selectR[i-1][2]).cost + paint[i][0].cost);
            selectR[i][1] = new home(min(selectR[i-1][0], selectR[i-1][2]).starthome, min(selectR[i-1][0], selectR[i-1][2]).cost + paint[i][1].cost);
            selectR[i][2] = new home(min(selectR[i-1][0], selectR[i-1][1]).starthome, min(selectR[i-1][0], selectR[i-1][1]).cost + paint[i][2].cost);

            selectG[i][0] = new home(min(selectG[i-1][1], selectG[i-1][2]).starthome, min(selectG[i-1][1], selectG[i-1][2]).cost + paint[i][0].cost);
            selectG[i][1] = new home(min(selectG[i-1][0], selectG[i-1][2]).starthome, min(selectG[i-1][0], selectG[i-1][2]).cost + paint[i][1].cost);
            selectG[i][2] = new home(min(selectG[i-1][0], selectG[i-1][1]).starthome, min(selectG[i-1][0], selectG[i-1][1]).cost + paint[i][2].cost);

            selectB[i][0] = new home(min(selectB[i-1][1], selectB[i-1][2]).starthome, min(selectB[i-1][1], selectB[i-1][2]).cost + paint[i][0].cost);
            selectB[i][1] = new home(min(selectB[i-1][0], selectB[i-1][2]).starthome, min(selectB[i-1][0], selectB[i-1][2]).cost + paint[i][1].cost);
            selectB[i][2] = new home(min(selectB[i-1][0], selectB[i-1][1]).starthome, min(selectB[i-1][0], selectB[i-1][1]).cost + paint[i][2].cost);
        }


        selectR[n-1][0] = new home(0, 10000001);
        selectG[n-1][1] = new home(0, 10000001);
        selectB[n-1][2] = new home(0, 10000001);

        int R = min(selectR[n-1][0], selectR[n-1][1],selectR[n-1][2]);
        int G = min(selectG[n-1][0], selectG[n-1][1],selectG[n-1][2]);
        int B = min(selectB[n-1][0], selectB[n-1][1],selectB[n-1][2]);

        System.out.println(Math.min(Math.min(R,G),B));

    }

    static class home {
        int starthome;
        int cost;
        public home(int starthome, int cost) {
            this.starthome = starthome;
            this.cost = cost;
        }
    }

    static home min(home a, home b) {
        if(a.cost < b.cost) {
            return a;
        } else {
            return b;
        }
    }
    static int min(home a, home b, home c) {
        return Math.min(Math.min(a.cost,b.cost),c.cost);
    }

    /** 2차원 배열 출력하기 */
    static public void printArray(home[][] array) {
        for (int i=0; i<array.length;i++) {
            for (int j=0; j<array[0].length;j++) {
                System.out.printf("%03d ",array[i][j].cost);
            }
            System.out.println("");
        }
    }
}
