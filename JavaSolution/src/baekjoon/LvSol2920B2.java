package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class LvSol2920B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(isOrder(input)?"ascending":isReverseOrder(input)?"descending":"mixed");

    }
    static boolean isOrder(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }

    static boolean isReverseOrder(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] < array[i + 1]);
    }
}