package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class LvSol1920S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Arrays.stream(bufferedReader.readLine().split(" ")).forEach(i -> {
            hashMap.put(Integer.parseInt(i),1);
        });

        int M = Integer.parseInt(bufferedReader.readLine());
        int[] num2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : num2) {
            System.out.println(hashMap.containsKey(i) ? 1 : 0);
        }
    }
}