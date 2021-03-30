package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol1085B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] xywh = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left    =   xywh[0];
        int right   =   xywh[2] -   xywh[0];
        int top     =   xywh[3] -   xywh[1];
        int bottom  =   xywh[1];

        System.out.println(Math.min(bottom,Math.min(top,Math.min(left,right))));
    }
}
