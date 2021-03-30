package Algo_Bookmark;

import java.io.IOException;
import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        ArrayList<Long> array = new ArrayList<>();
        for (int i=50; i<100; i++) {
            array.add((long)i);
        }
        System.out.println(binarySearch(array,50)); //0
        System.out.println(Range(array,50));        //1
        System.out.println(UpperBound(array,50));   //1
        System.out.println(LowerBound(array,50));   //0
    }

    /**
     * 2진 탐색으로 target 을 찾으면 해당 index 반환
     * */
    public static long binarySearch(ArrayList<Long> array, long target) {
        int low = 0;
        int high = array.size() - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (target > array.get(mid))
                low = mid + 1;
            else if (target < array.get(mid))
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }
    /**
     * Range : 정렬된 array 에서 target 의 개수 반환
     * */
    public static long Range(ArrayList<Long> array, long target) {
        return UpperBound(array,target)-LowerBound(array,target);
    }

    /**
     * LowerBound : 정렬된 array 에서 target 의 첫 인덱스 반환
     * */
    public static long LowerBound(ArrayList<Long> array, long target) {
        int low = 0;
        int high = array.size();
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (target <= array.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * UpperBound : 정렬된 array 에서 target 의 마지막 인덱스 반환
     * */
    public static int UpperBound(ArrayList<Long> array, long target) {
        int low = 0;
        int high = array.size();
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (target >= array.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
