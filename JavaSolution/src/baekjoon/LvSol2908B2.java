package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol2908B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        StringBuilder builder = new StringBuilder();
        int num = Integer.parseInt(builder.append(input[0]).reverse().toString());

        builder = new StringBuilder();
        int num2 = Integer.parseInt(builder.append(input[1]).reverse().toString());

        System.out.println(Math.max(num,num2));
    }
}
