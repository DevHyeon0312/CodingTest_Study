package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1Sol12910 {
    public static void main(String[] args) {
        int[] arr = {1,2,5,10};
        int divisor = 7;
        System.out.println(Arrays.toString(new Solution().solution(arr,divisor)));
    }
    static class Solution {
        public int[] solution(int[] arr, int divisor) {
            if(divisor == 1) {
                return Arrays.stream(arr).sorted().toArray();
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();

                for(int i : arr) {
                    if(i%divisor==0) {
                        arrayList.add(i);
                    }
                }
                if(arrayList.isEmpty()) {
                    return new int[]{-1};
                }
                return  arrayList.stream().sorted().mapToInt(i->i).toArray();
            }
        }
    }
}
