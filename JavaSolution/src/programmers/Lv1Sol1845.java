package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Lv1Sol1845 {
    public static void main(String[] args) {
        int[] arr = {3,3,3,2,2,4};
        System.out.println(solution(arr));
    }

    static public int solution(int[] nums) {
        int n = nums.length/2;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i,1);
        }
        return Math.min(hashMap.size(), n);
    }
}
