package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1Sol12906 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(
                Arrays.toString(new Solution().solution(arr))
        );
    }

    static public class Solution {
        public int[] solution(int []arr) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            int temp = -1;
            for (int i : arr) {
                if(temp != i) {
                    arrayList.add(i);
                    temp = i;
                }
            }
            return arrayList.stream().mapToInt(i->i).toArray();
        }
    }
}
