package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol2437G3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        /** 144ms */
        int minNumber = Integer.parseInt(bufferedReader.readLine()); minNumber = 1;
        int[] NUMS = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        for (int num : NUMS) {
            if(num>minNumber)
                break;
            else
                minNumber+=num;
        }
        System.out.println(minNumber);
    }
}

        /** 1800ms */
//        int minNumber;
//        int i=0;
//        while (true) {
//            i++;
//            if(searchIndex(NUMS,i) == -1) {
//                minNumber = i;
//                break;
//            } else {
//                if(isMake(NUMS, searchIndex(NUMS,i), i) == -1) {
//                    minNumber = i;
//                    break;
//                }
//            }
//        }
//        System.out.println(minNumber);
//    }
//
//    /** target 이 있으면 해당 index 반환. 없으면 target보다는 작은 값중 가장 큰값 반환 */
//    static int searchIndex(int[] NUMS , int target) {
//        int start = 0;
//        int end = NUMS.length;
//        int mid;
//        int result;
//        while(true) {
//            mid = (start+end)/2;
//            //target 이 없으므로, 가장 작은값중 큰값 반환 (만약 가장 작은값이 target 보다 크면 진짜 없으므로 -1 반환)
//            if(start >= mid) {
//                result = (mid == 0) ? (NUMS[mid] <= target)? mid : -1 : mid;
//                break;
//            }
//            //2진탐색
//            if(NUMS[mid] == target) {
//                result = mid;
//                break;
//            } else if(NUMS[mid] > target) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//        return result;
//    }
//
//    /** NUMS 배열을 이용하여 value 를 만들 수 있는지 판단 : max -> 0 으로 체크 */
//    static int isMake(int[] NUMS , int max, int value) {
//        int check = 0;
//        for(int i=max; i>=0; i--) {
//            check += NUMS[i];
//            if(value == check) {
//                return value;
//            } else if(value < check) {
//                check -= NUMS[i];
//            }
//        }
//        return -1;
//    }
//}
