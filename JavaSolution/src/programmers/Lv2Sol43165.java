package programmers;

import java.io.IOException;
import java.util.Arrays;

public class Lv2Sol43165 {
    public static void main(String[] args) throws IOException {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }
    static public int solution(int[] numbers, int target) {
        AddMinus(numbers,target,0,0);
        return count;
    }

    static int count = 0;
    static public void AddMinus(int[] numbers, int target, int number, int index) {
        if(index == numbers.length) {
            if(target==number) {
                count++;
            }
        } else {
            AddMinus(numbers,target,number+numbers[index],index+1);
            AddMinus(numbers,target,number-numbers[index],index+1);
        }
    }
}
