package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
public class LvSol1781G1 {
    public static void main(String[] args) throws IOException {
        List<Question> list = new ArrayList<>();
        PriorityQueue<Question> queue = new PriorityQueue<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //문제 입력받기
        int N = Integer.parseInt(reader.readLine());
        for(int i=0; i<N; i++) {
            String[] data = reader.readLine().split(" ");
            int line  = Integer.parseInt(data[0]);
            long ramen = Long.parseLong(data[1]);
            list.add(new Question(line, ramen));
        }
        //문제를 데드라인으로 정렬
        list.sort(new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                if(o1.line < o2.line) {
                    return 1;
                } else if(o1.line > o2.line) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int NOW_DAY = N; //최대 입력될 수 있는 날
        int count = 0;

        for (int i=0; i<list.size();) {
            Question question = list.get(i);
            //문제의 데드라인이 오늘 처리할 수 있는가?
            if(NOW_DAY <= question.line) {
                queue.add(question);
                System.out.println("입력된 ("+question.line+":"+question.ramen+") 문제는 "+NOW_DAY+"일차에 처리할 수 있으므로 큐에 넣습니다.");
                i++;
            }
            //오늘 처리할 수 없네?
            else {
                System.out.println("입력된 ("+question.line+":"+question.ramen+") 문제는 "+NOW_DAY+"일차에 처리할 수 없으므로 큐를 체크합니다.");
                //킵했던 문제들 중에 가장 라면을 많이주는 놈을 선택한다.
                if(!queue.isEmpty()) {
                    Question q = queue.poll();
                    count += q.ramen;
                    System.out.println("("+q.line+":"+q.ramen+") 문제는 "+NOW_DAY+"에 처리합니다.");
                } else {
                    System.out.println("큐가 비어있습니다.");
                }
                NOW_DAY--;
            }
        }

        while (NOW_DAY > 0) {
            //킵했던 문제들 중에 가장 라면을 많이주는 놈을 선택한다.
            if(!queue.isEmpty()) {
                Question q = queue.poll();
                count += q.ramen;
                System.out.println("("+q.line+":"+q.ramen+") 문제는 "+NOW_DAY+"에 처리합니다.");
            }
            NOW_DAY--;
        }
        System.out.println(count);
    }

    static class Question implements Comparable<Question> {
        private int line;   //1 ~ 200000
        private long ramen; //1 ~ 2^31
        public Question(int line, long ramen) {
            this.line  = line;
            this.ramen = ramen;
        }

        public int getLine() {
            return line;
        }

        public long getRamen() {
            return ramen;
        }

        @Override
        public int compareTo(Question target) {
            if(this.ramen < target.ramen) {
                return 1;
            } else if (this.ramen > target.ramen){
                return -1;
            } else {
                return 0;
            }
        }
    }
}


