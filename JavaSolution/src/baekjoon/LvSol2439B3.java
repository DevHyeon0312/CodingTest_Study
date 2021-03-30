package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol2439B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<N-1;i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("*");
        for (int i=0; i<N; i++) {
            System.out.println(stringBuilder);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append("*");
        }
    }
}
