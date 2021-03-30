package Algo_Bookmark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        getPrimeNumber(Integer.parseInt(bufferedReader.readLine()), Integer.parseInt(bufferedReader.readLine()));

        System.out.println(isPrimeNumber(8));
//        int[] primeNumbers = getPrimeNumber(1,100);
//        for (int i : primeNumbers) {
//            System.out.println(i);
//        }
    }

    /** 해당 숫자가 소수인지 판별 */
    public static boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        if (num%2 == 0) {
            return num == 2;
        }
        for(int i=3; i<=Math.sqrt(num); i += 2) {
            // 나눠 떨어진다면 약수에 해당하므로 소수가 아님.
            if( num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /** min이상 ~ max이하 의 모든 소수를 반환 */
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
