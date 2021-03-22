package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol13701G3 {
    public static void main(String[] args) throws IOException {
        //input : 공백을 구분으로 배열에 중복은 제거하고 입력된 순서대로 저장
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int [] N = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
        //output : 각 배열의 요소를 순서대로 공백을 삽입하여 문자열 재생성 후, trim 을 이용하여 마지막 공백 제거 후 출력
        StringBuilder builder = new StringBuilder();
        Arrays.stream(N).forEach(i->{builder.append(i).append(" ");});
        System.out.println(builder.toString().trim());
    }
}