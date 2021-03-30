package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol1008B4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double[] num = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        System.out.println(num[0]/num[1]);
    }
}
