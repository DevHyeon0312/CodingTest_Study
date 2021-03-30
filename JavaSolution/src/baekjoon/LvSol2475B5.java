package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LvSol2475B5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(br.readLine().split(" ")).mapToInt(i->(int)Math.pow(Integer.parseInt(i),2)).sum()%10);
    }
}