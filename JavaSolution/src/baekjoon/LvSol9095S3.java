package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LvSol9095S3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        while(N>0) {
            System.out.println(print123(Integer.parseInt(bufferedReader.readLine())));
            N--;
        }
    }

    static int print123(int number) {
        if(number < 3) {
            return number;
        }
        int[] NUM = new int[number+1];
        NUM[0] = 1;
        NUM[1] = 1;
        NUM[2] = 2;
        for(int i=3; i<=number; i++) {
            NUM[i] = NUM[i-1]+NUM[i-2]+NUM[i-3];
        }
        return NUM[number];
    }
}
