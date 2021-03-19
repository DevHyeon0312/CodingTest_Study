package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol5052G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());


        while (N > 0) {
            int K = Integer.parseInt(bufferedReader.readLine());
            String[] strings = new String[K];
            for(int i=0; i<K;i++) {
                strings[i] = bufferedReader.readLine();
            }
            strings = Arrays.stream(strings).sorted().toArray(String[]::new);
            boolean isStart = false;
            for(int i=0; i<K; i++) {
                for(int j=(i+1); j<K; j++) {
                    if(strings[j].startsWith(strings[i])) {
                        isStart = true;
                        break;
                    }
                    if (strings[j].length() >= strings[i].length()) {
                        break;
                    }
                }
                if(isStart) {
                    break;
                }
            }
            if(isStart) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            N--;
        }
    }
}
