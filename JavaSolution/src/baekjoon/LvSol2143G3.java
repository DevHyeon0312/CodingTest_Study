package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class LvSol2143G3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /** Input T */
        long T = Long.parseLong(bufferedReader.readLine()); //찾고자 하는 합 -10억 <= T <= 10억

        /** Input N & A[] */
        int N = Integer.parseInt(bufferedReader.readLine()); //A 배열의 크기
        int[] A = new int[N]; // -1000000 <= A[i] <= 1000000
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> arrayA = new ArrayList<>();
        for (int i=0; i<N;i++) {
            long sum = 0;
            for (int j=i;j<N;++j) {
                sum += A[j];
                arrayA.add(sum);
            }
        }

        /** Input M & B[] */
        int M = Integer.parseInt(bufferedReader.readLine()); //B 배열의 크기
        int[] B = new int[M]; // -1000000 <= B[i] <= 1000000
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<M;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> arrayB = new ArrayList<>();
        for (int i=0; i<M;i++) {
            long sum = 0;
            for (int j=i;j<M;j++) {
                sum += B[j];
                arrayB.add(sum);
            }
        }

        /** 정렬 */
        Collections.sort(arrayA);
        Collections.sort(arrayB);

        long count = 0;
        for (long l : arrayA) {
            long target = T-l;
//            System.out.print(l+"을"+T+"로 만들기 위해 ");
            count += Range(arrayB,target);
        }
        System.out.println(count);
    }

    /**
     * Range
     * */
    public static long Range(ArrayList<Long> array, long target) {
        return Upper(array,target)-Lower(array,target);
    }

    /**
     * Lower
     * */
    public static long Lower(ArrayList<Long> array, long target) {
        /** 2진 탐색으로 target찾기 */
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
     * Upper
     * */
    public static int Upper(ArrayList<Long> array, long target) {
        /** 2진 탐색으로 target찾기 */
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