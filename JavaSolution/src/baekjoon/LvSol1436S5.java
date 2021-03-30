package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol1436S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int count = 0;
        int i=666;
        while (true) {
            String name = i+"";
            if(name.contains("666")) {
                count++;
            }
            if(count == N) {
                System.out.println(name);
                break;
            }
            i++;
        }
    }
}