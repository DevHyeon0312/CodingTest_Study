package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol21314S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = bufferedReader.readLine().toCharArray();

        System.out.println(getBigNumber(arr));
        System.out.println(getSmallNumber(arr));
    }

    public static String getBigNumber(char[] arr) {
        String result = "";

        long Mcnt = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 'M') {
                Mcnt++;
            } else if (arr[i] == 'K') {
                result+=5;
                for(int j=0; j<Mcnt;j++) {
                    result+=0;
                }
                Mcnt = 0;
            }
        }
        if (Mcnt>0) {
            for (int i=0; i<Mcnt; i++) {
                result += 1;
            }
        }
        return result;
    }

    public static String getSmallNumber(char[] arr) {
        String result = "";

        long Mcnt = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 'M') {
                Mcnt++;
            } else if (arr[i] == 'K') {
                if(Mcnt>0) {
                    result += 1;
                    Mcnt--;
                    for (int j=0; j<Mcnt;j++) {
                        result+=0;
                    }
                }
                result += 5;
                Mcnt = 0;
            }
        }

        if (Mcnt>0) {
            result += 1;
            Mcnt--;
            for (int j=0; j<Mcnt;j++) {
                result+=0;
            }
        }

        return result;
    }
}
