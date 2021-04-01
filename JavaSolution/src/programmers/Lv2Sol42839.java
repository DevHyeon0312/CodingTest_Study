package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Lv2Sol42839 {

    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        public int solution(String numbers) {
            int answer = 0;

            int array[] = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
            int N = array.length;
            /** 모든 경우의 수 구하기 : 중복비허용 */
            ArrayList<Integer> arrayList = new ArrayList<>();
            int[] output = new int[N];
            int nullValue = -1;
            for (int i=0; i<N; i++) {
                output[i] = nullValue;
            }
            for(int cnt=1; cnt<=N; cnt++) {
                arrayList.addAll(fullAdd(array, output, new boolean[N], 0, N, cnt, -1));
            }

            for (int i: arrayList.stream().distinct().mapToInt(i->i).toArray()) {
                if (isPrimeNumber(i)) {
                    answer++;
                }
            }

            return answer;
        }
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

    /** int[] 배열내부 전체 모든 경우의 수 : ex. 1,2,3 != 1,3,2 */
    public static ArrayList<Integer> fullAdd(int[] array, int[] output, boolean[] isVisit, int depth, int length, int count, int nullValue) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(count==0) {
            StringBuilder builder = new StringBuilder();
            for (int i : output) {
                if(i!=-1) {
                    builder.append(i);
                }
            }
            arrayList.add(Integer.parseInt(builder.toString()));
            return arrayList;
        }
        for(int i=0; i<length; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                output[depth] = array[i];
                arrayList.addAll(fullAdd(array, output, isVisit, depth+1, length, count-1,nullValue));
                isVisit[i] = false;
            }
        }
        return arrayList;
    }
}
