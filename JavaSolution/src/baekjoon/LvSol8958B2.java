package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol8958B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i=0; i<N; i++) {
            char[] chars = bufferedReader.readLine().toCharArray();
            int total = 0;
            int score = 0;
            for (char c : chars) {
                if (c == 'O') {
                    score++;
                    total += score;
                } else {
                    score = 0;
                }
            }
            System.out.println(total);
        }
    }
}