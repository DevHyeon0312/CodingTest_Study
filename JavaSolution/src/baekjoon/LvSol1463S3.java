package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol1463S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        if(n==1) {
            System.out.println(0);
            return;
        } else if(n==2 || n==3) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=n; i++) {
            dp[i] = 999999;
            int checkA = i%3==0 ? i/3 : i;
            int checkB = i%2==0 ? i/2 : i;
            int checkC = i-1;
            dp[i] = 1 + Math.min(Math.min(dp[checkA],dp[checkB]),dp[checkC]);
        }
        System.out.println(dp[n]);
    }
}
