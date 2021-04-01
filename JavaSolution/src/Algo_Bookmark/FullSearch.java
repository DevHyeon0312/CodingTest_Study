package Algo_Bookmark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FullSearch {
    public static void main(String[] args) throws IOException {
        int N = 6;
        int[] array = {0,1,2,3,4,5};
        /** 2개씩 더하기 중복비허용 */
        //fullAdd_no(array);
        /** 2개씩 더하기 중복허용 */
        //fullAdd_yes(array);

        /** 모든 경우의 수 구하기 : 중복허용 */
        ArrayList<int[]> arrayList = new ArrayList<>();
        int[] output = new int[N];
        int nullValue = -1;
        for (int i=0; i<N; i++) {
            output[i] = nullValue;
        }
        for(int cnt=1; cnt<=N; cnt++) {
            arrayList.addAll(fullAdd(array, output, new boolean[N], 0, N, cnt, -1));
        }
        for (int[] i: arrayList) {
            System.out.println(Arrays.toString(i));
        }
    }

    /** int[] 배열내부를 2개 씩 더하기 : 중복 없음 */
    public static void fullAdd_no(int[] arr) {
        System.out.println("2개씩 더하기 : 중복 없음 (ex. 1+2 = 2+1)");
        for (int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length;j++) {
                System.out.println(arr[i]+"+"+arr[j]+"="+(arr[i]+arr[j]));
            }
        }
    }
    /** int[] 배열내부를 2개 씩 더하기 : 중복있음 */
    public static void fullAdd_yes(int[] arr) {
        System.out.println("2개씩 더하기 : 중복 있음 (ex. 1+2 != 2+1)");
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length;j++) {
                if(i!=j) {
                    System.out.println(arr[i]+"+"+arr[j]+"="+(arr[i]+arr[j]));
                }
            }
        }
    }

    /** int[] 배열내부 전체 모든 경우의 수 : ex. 1,2,3 != 1,3,2 */
    public static ArrayList<int[]> fullAdd(int[] array, int[] output, boolean[] isVisit, int depth, int length, int count, int nullValue) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        if(count==0) {
            arrayList.add(Arrays.stream(output).filter(i->i!=nullValue).toArray());
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

    /** int[] 배열내부 전체 모든 경우의 수 : ex. 1,2,3 != 1,3,2 를 정수로 반환 */
    public static ArrayList<Integer> fullAdd_toInt(int[] array, int[] output, boolean[] isVisit, int depth, int length, int count, int nullValue) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(count==0) {
            StringBuilder builder = new StringBuilder();
            for (int i : output) {
                if(i!=-1) {
                    builder.append(i);
                }
            }
            arrayList.add(Integer.parseInt(builder.toString()));

            //중복 허용
            return arrayList;
        }
        for(int i=0; i<length; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                output[depth] = array[i];
                arrayList.addAll(fullAdd_toInt(array, output, isVisit, depth+1, length, count-1,nullValue));
                isVisit[i] = false;
            }
        }
        return arrayList;
    }
}
