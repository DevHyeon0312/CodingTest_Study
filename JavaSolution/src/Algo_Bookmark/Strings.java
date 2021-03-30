package Algo_Bookmark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    /** 문자열 뒤집기 */
    static String stringReverse(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        return builder.reverse().toString();
    }
}
