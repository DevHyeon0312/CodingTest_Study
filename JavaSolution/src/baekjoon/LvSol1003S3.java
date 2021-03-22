package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol1003S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[41];
        int lastIndex = 2;
        dp[0] = 0;
        dp[1] = 1;
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if(num == 0) {
                builder.append("1 0");
            } else {
                if(dp[num] == 0) {
                    for(int j=lastIndex; j<=num; j++) {
                        dp[j] = dp[j-1]+dp[j-2];
                        lastIndex=j;
                    }
                }
                builder.append(dp[num-1]).append(" ").append(dp[num]);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
