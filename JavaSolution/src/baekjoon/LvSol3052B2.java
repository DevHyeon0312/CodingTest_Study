package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LvSol3052B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0; i<10; i++) {
            hashMap.put(Integer.parseInt(bufferedReader.readLine())%42,1);
        }
        System.out.println(hashMap.size());
    }
}
