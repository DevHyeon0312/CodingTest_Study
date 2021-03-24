package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol21313B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());


        String result = "";
        if(N%2 == 0) {
            for (int i=0; i<N; i++) {
                if(i%2==0) {
                    result+="1 ";
                } else {
                    result+="2 ";
                }
            }
        } else {
            for (int i=0; i<N-1; i++) {
                if(i%2==0) {
                    result+="1 ";
                } else {
                    result+="2 ";
                }
            }
            result+="3";
        }
        System.out.println(result);
    }
}

