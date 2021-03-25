package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol11726S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        long[] dp = new long[N+1];
        switch (N) {
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println(N);
                break;
            default:
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 3;
                for(int i=4; i<=N; i++) {
                    dp[i] = (dp[i-1] + dp[i-2])%10007;
                }
                System.out.println(dp[N]);
                break;
        }
    }
}
