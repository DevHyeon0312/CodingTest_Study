package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LvSol10869B5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(nums[0]+nums[1]);
        System.out.println(nums[0]-nums[1]);
        System.out.println(nums[0]*nums[1]);
        System.out.println(nums[0]/nums[1]);
        System.out.println(nums[0]%nums[1]);
    }
}