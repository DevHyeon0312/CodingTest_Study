package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LvSol1929S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : getPrimeNumber(nums[0],nums[1])) {
            System.out.println(i);
        }
    }

    /** 소수 전부 반환 */
    public static int[] getPrimeNumber(int min, int max) {
        int[] nums = new int[max+1];
        Arrays.fill(nums,1);

        for (int i = 2; i <= max; i++) {
            if (nums[i] == 0) { // 이미 체크된 수의 배수는 확인하지 않는다
                continue;
            }

            for (int j = i + i; j <= max; j += i) { // i를 제외한 i의 배수들은 0으로 체크
                nums[j] = 0;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=min; i<=max; i++) {
            if (nums[i] != 0) {
                list.add(i);
            }
        }
        if(list.get(0)==1) {
            list.remove(0);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
