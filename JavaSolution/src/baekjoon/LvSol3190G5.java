package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LvSol3190G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        /** 게임 보드 */
        int N = Integer.parseInt(bufferedReader.readLine()); //보드의 크기 (2 <= N <= 100)
        int[][] BOARD = new int[N+2][N+2];
        for (int i=0; i<N+2;i++) {
            BOARD[i][0] = -1;
            BOARD[0][i] = -1;
            BOARD[N+1][i] = -1;
            BOARD[i][N+1] = -1;
        }

        /** 사과 */
        int K = Integer.parseInt(bufferedReader.readLine()); //사과의 개수 (0 <= K <= 100)
        for (int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            BOARD[x][y] = 2;
        }

        /** 뱀 이동정보 */
        int L = Integer.parseInt(bufferedReader.readLine()); // 뱀 이동 횟수 : 1 <= L <= 100  , 이동방향 : C = L(-90도) or D(90도) 회전
        Queue<MOVE> moveQueue = new LinkedList<>();   //뱀이 이동한 정보를 담아두는 큐
        Deque<SNAKE> snakeQueue = new LinkedList<>(); //뱀의 현재 위치를 담아두는 뎈
        for (int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int time = Integer.parseInt(st.nextToken());    // time 초까지 직진
            int move = st.nextToken().equals("D") ? 1 : -1; // time 초 후에 move. 1은  90도, -1은 -90도 회전
            moveQueue.add(new MOVE(time,move));
        }
        //뱀의 시작점
        snakeQueue.add(new SNAKE(1,1));
        BOARD[1][1] = -1;


        /** 게임 스타뜨 >< */
        int move = 1; // 1=우, 2=하, 3=좌, 4=상
        int playTime = 0;
        while (true) {
            //뱀의 다음 움직임
            MOVE moving = null;
            if(!moveQueue.isEmpty()) {
                moving = moveQueue.peek();
            }
            playTime++;

            SNAKE headTmp = snakeQueue.peekFirst(); //머리임시 : 무조껀 재삽입이므로 peek
            SNAKE tailTmp = snakeQueue.pollLast();  //꼬리임시 : 유지될지(재삽입=addLast(tail)), 삭제될지(미호출)
            SNAKE tail = new SNAKE(tailTmp.x,tailTmp.y); //꼬리
            SNAKE head = new SNAKE(headTmp.x,headTmp.y);//머리
            switch (move) {
                case 1://우
                    head.x++;
                    break;
                case 2://하
                    head.y++;
                    break;
                case 3://좌
                    head.x--;
                    break;
                case 4://상
                    head.y--;
                    break;
            }
            //벽 또는 자기 자신을 만나면 종료
            if (BOARD[head.y][head.x] == -1) {
                break;
            }
            //사과를 먹으면 몸통이 길어나요
            if(BOARD[head.y][head.x] == 2) {
                BOARD[head.y][head.x] = -1;
                snakeQueue.addLast(tail);
                snakeQueue.addFirst(head);
            }
            //사과를 먹지 못하면 무빙을 해여
            else {
                BOARD[tail.y][tail.x] = 0;
                BOARD[head.y][head.x] = -1;
                snakeQueue.addFirst(head);
            }

            //방향을 바꿀지 말지 결정 : 이동정보가 있는 상황이면 해당 이동정보의 시간에 이동정보 적용
            if(moving != null && playTime == moving.time) {
                move = move + moving.move;
                move = move > 4 ? 1 : move < 1 ? 4 : move;
                moveQueue.poll();
            }
        }

        print2array(BOARD);
        System.out.println(playTime);
    }

    /** 뱀이 움직이는 정보 객체*/
    static class MOVE {
        int time;// time 초까지 직진
        int move;// time 초 후에 move. 1은  90도, -1은 -90도 회전
        public MOVE(int time, int move) {
            this.time = time;
            this.move = move;
        }
    }

    /** 뱀의 현재 위치 객체 */
    static class SNAKE {
        int x; //뱀의 행 좌표
        int y; //뱀의 열 좌표
        public SNAKE(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void print2array(int[][] array) {
        for (int i=0; i<array.length;i++) {
            for (int j=0; j<array.length;j++) {
                System.out.printf("%02d  ",array[i][j]);
            }
            System.out.println("");
        }
    }
}
