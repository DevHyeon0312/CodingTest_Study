package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol2839B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        /** 초기 셋팅 */
        int[] dp = new int[N+6];
        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for (int i=6; i<N+1; i++) {
            if(dp[i-3] == -1 && dp[i-5] == -1) {
                dp[i] = -1;
            } else if (dp[i-3] == -1) {
                dp[i] = dp[i-5] + 1;
            } else if(dp[i-5] == -1) {
                dp[i] = dp[i-3] + 1;
            } else {
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            }
        }
        System.out.println(dp[N]);
    }
}
