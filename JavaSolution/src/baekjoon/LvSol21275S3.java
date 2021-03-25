package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol21275S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //str[0] = A , str[1] = B
        String[] str = bufferedReader.readLine().split(" ");

        //A의 최소 표현 진법
        int MaxA = Arrays.stream(str[0].split("")).mapToInt(s -> s.charAt(0)-86).max().orElseThrow();
        if(MaxA < 0) MaxA = Math.max(MaxA + 39, 2);

        //B의 최소 표현 진법
        int MaxB = Arrays.stream(str[1].split("")).mapToInt(s -> s.charAt(0)-86).max().orElseThrow();
        if(MaxB < 0) MaxB = Math.max(MaxB + 39, 2);

        //결과 출력용 변수
        long resultX = 0; //X값
        int resultA = 0;  //A진법
        int resultB = 0;  //B진법
        StringBuilder builder = new StringBuilder();

        //계산코드
        int count = 0;
        for(int i=MaxA; i<=36; i++) {
            for(int j=MaxB; j<=36; j++) {
                if(i==j) {
                    continue;
                }
                if((Nto10(str[0],i) != -1 && Nto10(str[1],j) != -1 ) && Nto10(str[0],i) == Nto10(str[1],j)) {
                    count++;
                    resultX = Nto10(str[0],i);
                    resultA = i;
                    resultB = j;
                }
            }
            if(count > 1) {
                break;
            }
        }

        //Print
        if(count == 0) {
            builder.append("Impossible");
        } else if(count == 1) {
            builder.append(resultX).append(" ").append(resultA).append(" ").append(resultB);
        } else {
            builder.append("Multiple");
        }
        System.out.println(builder);
    }

    static long Nto10(String num, int N) {
        try {
            return Long.parseLong(num,N);
        }catch (Exception e) {
            return -1;
        }
    }
}