package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class LvSol17298G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=array.length-1; i>=0; i--) {
            while(true) {
                if(stack.empty()) {
                    result[i] = -1;
                    stack.push(array[i]);
                    break;
                }
                int last = stack.peek();
                if(last > array[i]) {
                    result[i] = last;
                    stack.push(array[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i : result) {
            builder.append(i+" ");
        }
        System.out.println(builder);
    }
}
