package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LvSol2292B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        if(N==1) {
            System.out.println(1);
            return;
        }

        int addNumber = 12;
        ArrayList<Integer> maxList = new ArrayList<>();
        maxList.add(1);
        maxList.add(7);

        int index = 1;
        while (true) {
            if(maxList.get(index-1) < N && N <= maxList.get(index)) {
                System.out.println(index+1);
                break;
            } else {
                maxList.add(maxList.get(index) + addNumber);
                addNumber += 6;
                index++;
            }
        }
    }
}
