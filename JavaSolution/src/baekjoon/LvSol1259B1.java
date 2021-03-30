package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol1259B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            if(s.equals("0")) {
                break;
            } else {
                if(s.equals(stringReverse(s))) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

    static String stringReverse(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        return builder.reverse().toString();
    }
}
