package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LvSol1181S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        String[] strings = new String[N];
        for (int i=0; i<N; i++) {
            strings[i] = bufferedReader.readLine();
        }
        List<String> list = Arrays.stream(strings).distinct().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return -1;
            }
        }).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
