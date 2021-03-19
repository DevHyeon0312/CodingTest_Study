package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol1065S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        for(int i=1; i<=n; i++) {
            if(checkNumber(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean checkNumber(int n) {
        String str = n+"";
        if(str.length()==1 || str.length()==2) {
            return true;
        } else {
            int size = Integer.parseInt(str.charAt(1)+"") - Integer.parseInt(str.charAt(0)+"");
            for(int i=1; i<str.length();i++) {
                if(Integer.parseInt(str.charAt(i)+"") - Integer.parseInt(str.charAt(i-1)+"") != size) {
                    return false;
                }
            }
            return true;
        }
    }
}