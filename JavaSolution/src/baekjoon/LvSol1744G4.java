package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LvSol1744G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //Input N
        int N = Integer.parseInt(bufferedReader.readLine());

        //Input ArrayList
        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> minusList = new ArrayList<>();
        int zero = 1;
        for(int i=0; i<N;i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            //0이 입력되면, 나중에 남는 음수를 0이랑 곱해서 0으로 바까줘야함.
            if(num==0) {
                zero = 0;
            }
            //양수는 양수리스트
            else if(num > 0) {
                plusList.add(num);
            }
            //음수는 음수리스트
            else {
                minusList.add(num);
            }
        }

        //ArrayList to Array
        int[] plus = plusList.stream().sorted().mapToInt(i->i).toArray();
        int[] minus = minusList.stream().sorted().mapToInt(i->i).toArray();

        //최대 합
        long sum = 0;

        //양수 더하기 (length to 0)
        int plusIndex = plus.length-1;
        while(plusIndex >= 0) {
            if(plusIndex == 0) {
                sum += plus[plusIndex];
            } else {
                if (plus[plusIndex] == 1 || plus[plusIndex-1] == 1) {
                    sum += (plus[plusIndex] + plus[plusIndex-1]);
                } else {
                    sum += (plus[plusIndex] * plus[plusIndex-1]);
                }
            }
            plusIndex-=2;
        }

        //음수 더하기 (0 to length) -> 역순정렬하면 length to 0 로 해도 됨.
        int minusIndex = 0;
        while (minusIndex < minus.length) {
            if(minusIndex+1 == minus.length) {
                sum += (minus[minusIndex] * zero);
            } else {
                sum += (minus[minusIndex] * minus[minusIndex+1]);
            }
            minusIndex+=2;
        }
        System.out.println(sum);
    }
}
