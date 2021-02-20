import cordingtest.Solution1;
import oncoder.BrokenButton;
import programmers.Lv1StringToInteger;
import programmers.Lv2Sol68645;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //System.out.println("Create Solution Project");

        /** 2020.12.19 코딩테스트 1번 */
        //input
        String[] record =
                {"jack:9,10,13,9,15","jerry:7,7,14,10,17","jean:0,0,11,20,0","alex:21,2,7,11,4","kevin:8,4,5,0,0","brown:3,5,16,3,18","ted:0,8,0,0,8","lala:0,12,0,7,9","hue:17,16,8,6,10","elsa:11,13,10,4,13"};
        String[] result = new Solution1().solution(record);

        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println(" ");

        //output
        System.out.print(result);

        /** 2020.12.19 코딩테스트 2번 */
        //input

        //output

        /** 2020.12.19 코딩테스트 3번 */
        //input

        //output

        /** 2020.12.19 코딩테스트 4번 */
        //input

        //output

        /** 2020.12.19 코딩테스트 5번 */
        //input

        //output
    }
}