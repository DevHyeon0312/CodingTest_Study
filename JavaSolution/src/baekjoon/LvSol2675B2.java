package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol2675B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i=0; i<N; i++) {
            StringBuilder builder = new StringBuilder();
            String[] str = bufferedReader.readLine().split(" ");
            for (int j=0; j<str[1].length();j++) {
                for (int k=0; k<Integer.parseInt(str[0]); k++) {
                    builder.append(str[1].charAt(j));
                }
            }
            System.out.println(builder);
        }
    }
}
