package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LvSol10828S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Stack<String> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            String[] strArray = bufferedReader.readLine().split(" ");
            switch (strArray[0]) {
                case "push":
                    stack.push(strArray[1]);
                    break;
                case "top":
                    if(stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "empty":
                    System.out.println(stack.isEmpty()?"1":"0");
                    break;
            }
        }
    }


}
