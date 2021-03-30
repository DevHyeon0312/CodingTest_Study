package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol2742B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i=N; i>1;i--) {
            builder.append(i).append("\n");
        }
        builder.append(1);
        System.out.println(builder);
    }
}
