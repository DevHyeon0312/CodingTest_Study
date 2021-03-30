package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol21312B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrInt = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxA = 0; //홀수 최대
        int maxB = 0; //짝수 최대

        for (int i=0; i<3; i++) {
            if(arrInt[i]%2 == 1) {
                maxA = Math.max(maxA,arrInt[i]);
            } else {
                maxB = Math.max(maxB,arrInt[i]);
            }
            for (int j=0; j<3; j++) {
                if (i==j) {
                    continue;
                }
                int num = arrInt[i]*arrInt[j];
                if(num%2 == 1) {
                    maxA = Math.max(maxA,num);
                } else {
                    maxB = Math.max(maxB,num);
                }
                for (int k=0; k<3; k++) {
                    if(j==k || i==k) {
                        continue;
                    }
                    int num2 = num*arrInt[k];
                    if(num2%2 == 1) {
                        maxA = Math.max(maxA,num2);
                    } else {
                        maxB = Math.max(maxB,num2);
                    }
                }
            }
        }
        System.out.println(maxA != 0 ? maxA : maxB);
    }
}