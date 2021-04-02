package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv2Sol42747 {
    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(solution(array));
    }

    static public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i=1; i<=citations.length;i++) {
            System.out.println(i+":"+LowerBound(citations,i));
            if(i <= (citations.length - LowerBound(citations,i))) {
                max = Math.max(max,i);
            }
        }

        return max;
    }

    public static int LowerBound(int[] array, int target) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (target <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
