package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LvSol2170G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        LINE[] lines = new LINE[N];

        //input
        for(int i=0; i<N; i++) {
            int[] temp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lines[i] = new LINE(temp[0],temp[1]);
        }

        //Sort
        Arrays.sort(lines, new Comparator<LINE>() {
            @Override
            public int compare(LINE o1, LINE o2) {
                if(o1.x1 > o2.x1) {
                    return 1;
                } else if(o1.x1 < o2.x1) {
                    return -1;
                }
                return Integer.compare(o2.x2, o1.x2);
            }
        });

        //Search
        int start = lines[0].x1;
        int end = lines[0].x2;
        int result = end-start;
        for(int i=1; i<N; i++) {
            //next 선분이 현재 선분에 부분 포함
            if((lines[i].x1 < end) && (lines[i].x2 > end)) {
                //현재 선분에 이어 붙임.
                result += (lines[i].x2 - end);
                end = lines[i].x2;
            }
            //next 선분이 현재 선분에 포함되지 않음.
            else if(lines[i].x1 > end) {
                //현재 선분을 변경함.
                start = lines[i].x1;
                end = lines[i].x2;
                result += (end-start);
            }
        }
        System.out.println(result);
    }

    //Object
    static class LINE {
        int x1;
        int x2;
        public LINE(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}


/*
10
1 10
1 30
-3 13
3 9
3 35
6 14
7 8
2 6
2 9
2 4
* */