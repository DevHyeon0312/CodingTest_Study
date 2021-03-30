package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol1152B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //문자열 앞,뒤 공백이 제거가 안되서 오답
        System.out.println(Arrays.stream(bufferedReader.readLine().split(" ")).count());

        //문자열 길이가 0인 놈이 카운트되서 오답
        System.out.println(Arrays.stream(bufferedReader.readLine().trim().split(" ")).count());

        //정답
        System.out.println(Arrays.stream(bufferedReader.readLine().trim().split(" ")).filter(s->s.length()!=0).count());
    }
}
