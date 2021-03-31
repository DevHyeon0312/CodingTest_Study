package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lv2Sol42578 {
    public static void main(String[] args) throws IOException {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
        System.out.println(solution(clothes2));
    }

    public static int solution(String[][] clothes) {
        //곱셈을 위해 1부터 시작
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 옷 종류 해쉬맵에 옷 개수를 담기
        for (String[] cloth : clothes) {
            hashMap.merge(cloth[cloth.length-1],cloth.length-1,Integer::sum);
        }

        // 경우의 수 체크 answer *= (옷 개수 + 안 입을 경우)
        for (int val : hashMap.values()){
            answer *= (val+1);
        }

        //1부터 시작한거 빼기
        return answer-1;
    }
}
