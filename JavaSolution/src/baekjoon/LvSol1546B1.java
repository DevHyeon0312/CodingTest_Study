package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol1546B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        double[] scores = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double max = Arrays.stream(scores).max().orElse(0);

        double aver = 0;
        for (int i=0; i<N;i++) {
            aver+= scores[i]/ (max) * 100;
        }
        System.out.println(aver/N);
    }
}