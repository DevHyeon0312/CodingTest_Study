package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol1157B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[26];
        char[] chars = bufferedReader.readLine().toUpperCase().toCharArray();
        for (char c : chars) {
            alphabet[(int)c-65]++;
        }

        int result = -1;
        int max = 0;
        for (int i=0; i<26; i++) {
            if(max < alphabet[i]) {
                max = alphabet[i];
                result = (char)(i+65);
            } else if(max == alphabet[i]) {
                result = -1;
            }
        }
        System.out.println(result==-1?"?":(char)result);
    }
}