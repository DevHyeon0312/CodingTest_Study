package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol11053S2 {
    public static void main(String[] args) throws IOException {
        /* Input */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int [] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] dp = new int[n];

        /**
         * 1. array[index] 의 왼쪽에 데이터가 있는가?
         * 2. array[index] 의 왼쪽에 데이터가 없으면 dp[index] = 1
         * 3. array[index] 의 왼쪽에 데이터가 있으면 데이터중 array[index] 의 값보다 작은 값들 중, 가장 큰 dp[target] 값을 갖는 Data를 발견하면, dp[index] = dp[target] + 1
         * */
        int MAX = 1;
        dp[0] = 1;
        /* left -> right : array Data check. */
        for(int i=1; i<n; i++) {
            int input = array[i];
            int maxDP = dp[i];
            /* left -> right : target check */
            for(int target=0; target<i; target++) {
                int targetData  = array[target];
                int targetDP    = dp[target];
                if(input > targetData && maxDP < targetDP) {
                    maxDP = targetDP;
                }
            }
            dp[i] = maxDP + 1;
            if(MAX < dp[i]) {
                MAX = dp[i];
            }
         }
        System.out.println(MAX);
    }
}
