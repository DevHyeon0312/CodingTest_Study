package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LvSol11000G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        //입력된 강의실
        PriorityQueue<ROOM> inputQueue = new PriorityQueue<>();
        PriorityQueue<SAVE> outputQueue = new PriorityQueue<>();

        //input
        for(int i=0; i<N; i++) {
            int[] temp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inputQueue.add(new ROOM(temp[0],temp[1]));
        }

        //우선순위가 높은것들을 먼저 poll.
        while(!inputQueue.isEmpty()) {
            ROOM r1 = inputQueue.poll();
            if(!outputQueue.isEmpty()) {
                SAVE r2 = outputQueue.poll();
                if(r2.endTime <= r1.startTime) {
                    r2.endTime = r1.endTime;
                    outputQueue.add(r2);
                } else {
                    outputQueue.add(r2);
                    outputQueue.add(new SAVE(r1.endTime));
                }
            } else {
                outputQueue.add(new SAVE(r1.endTime));
            }
        }
        System.out.println(outputQueue.size());
    }

    /** 강의실 객체 */
    static class ROOM implements Comparable<ROOM> {
        int startTime;
        int endTime;

        public ROOM(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }

        @Override
        public int compareTo(ROOM o) {
            //시작시간이 빠를수록 우선순위가 높다.
            if(this.startTime > o.startTime) {
                return 1;
            } else if(this.startTime < o.startTime) {
                return -1;
            }
            //시작시간이 같으면, 종료시간이 빠를수록 우선순위가 높다.
            if(this.endTime > o.endTime) {
                return 1;
            } else if(this.endTime < o.endTime) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    static class SAVE implements Comparable<SAVE> {
        int endTime;
        public SAVE(int time) {
            this.endTime = time;
        }

        @Override
        public int compareTo(SAVE o) {
            return Integer.compare(this.endTime, o.endTime);
        }
    }
}
