package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol2309B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] user = new int[9];
        for (int i = 0; i < 9; i++) {
            user[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int sum = Arrays.stream(user).sum();
        for(int i=0; i<9;i++) {
            int temp = user[i];
            boolean isSuccess = false;
            for(int j=(i+1); j<9;j++) {
                temp += user[j];
                if(sum - temp == 100) {
                    user[i] = -1;
                    user[j] = -1;
                    isSuccess = true;
                    break;
                } else {
                    temp = user[i];
                }
            }
            if(isSuccess) {
                break;
            }
        }

        for(int i : Arrays.stream(user).filter(i->i!=-1).sorted().toArray()) {
            System.out.println(i);
        }
    }
}

