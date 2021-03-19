package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol2231B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<N; i++) {
            int number = i;
            String numstring = number+"";
            for(int j=0; j<numstring.length();j++) {
                number += Integer.parseInt(numstring.charAt(j)+"");
            }
            if(number == N) {
                System.out.println(numstring);
                return;
            }
        }
        System.out.println("0");
    }
}
