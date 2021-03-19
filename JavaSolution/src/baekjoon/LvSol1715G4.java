package baekjoon;

import java.io.*;
import java.util.*;

public class LvSol1715G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int sum = 0;
        while (queue.size()!=1) {
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a+b);
            sum += a+b;
        }

        System.out.println(sum);
    }
}

// 10 20 40 50 60
// 10+20
// 30+40
// 70 +50
// 120 +60