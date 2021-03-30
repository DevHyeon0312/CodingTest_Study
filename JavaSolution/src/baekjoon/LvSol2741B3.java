package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol2741B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<N-1;i++) {
            builder.append(i+1).append("\n");
        }
        builder.append(N);
        System.out.println(builder);
    }
}