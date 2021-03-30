package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LvSol1654S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lan = new long[K];
        long start = 1;
        long end = 0;
        long mid;
        long sum;

        /** O(N) */
        for (int i = 0; i < K; i++) {
            lan[i] = Long.parseLong(bufferedReader.readLine());
            end = Math.max(end, lan[i]);
        }

        while (start <= end) {
            mid = (start + end) >> 1;
            sum = 0;
            for (int i = 0; i < K; i++) {
                sum += lan[i] / mid;
            }
            if (sum >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}