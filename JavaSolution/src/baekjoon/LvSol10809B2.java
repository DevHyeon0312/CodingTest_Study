package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol10809B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        Arrays.fill(count,-1);
        char[] chars = bufferedReader.readLine().toCharArray();

        for (int i=0; i<chars.length;i++) {
            int c = (int)chars[i]-97;
            if(count[c] == -1) {
                count[c] = i;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<26; i++) {
            builder.append(count[i]).append(" ");
        }
        System.out.println(builder);
    }
}
