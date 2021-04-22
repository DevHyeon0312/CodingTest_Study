package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol2467G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(array);
    }

    static public void solution(int[] array) {
        Arrays.sort(array);
        int lp = 0;
        int rp = array.length-1;
        int sum = 2000000001;
        int lsave = 0;
        int rsave = 0;

        while (lp != rp) {
            int temp = array[lp] + array[rp];
            if(temp == 0) {
                lsave = lp;
                rsave = rp;
                break;
            } else if(temp > 0) {
                if (Math.abs(sum) > Math.abs(temp)) {
                    sum = temp;
                    lsave = lp;
                    rsave = rp;
                }
                rp--;
            } else {
                if (Math.abs(sum) > Math.abs(temp)) {
                    sum = temp;
                    lsave = lp;
                    rsave = rp;
                }
                lp++;
            }
        }
        System.out.println(Math.min(array[lsave],array[rsave]) +" " + Math.max(array[lsave],array[rsave]));
    }
}
