package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol1662G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        int[] array = new int[s.length()/2+1];
        int index=0;
        int len = 0;
        for(int i=0; i<s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    len = len * array[--index] + array[--index];
                    array[index] = len;
                    break;
                case '(':
                    array[index++] = --len;
                    len = 0;
                    array[index++] = Integer.parseInt(s.charAt(i-1)+"");
                    break;
                default:
                    array[index] = ++len;
                    break;
            }
        }
        System.out.println(array[0]);
    }
    //33(562(71(9)))
    //3(562(72(9)))
    //3(3(3(2(2)2(2))))

    //3(3(3(2(2)
    //3(3(3(22
    //3(3(3(222(2)
    //3(3(3(2222
    //3(3(3(2222)
    //3(3(222222222222
    //3(3(222222222222)
}
