package programmers;

import java.util.ArrayList;

public class Lv2Sol42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        int result = 0;
        boolean isBool = false;
        for (int i=0; i <progresses.length;) {
            //Up
            if (progresses[i] < 100) {
                AddProgresses(progresses, speeds);
                if (isBool) {
                    answer.add(result);
                    result = 0;
                }
                isBool = false;
            }
            //Output
            else {
                i++;
                result++;
                isBool = true;
            }
        }

        answer.add(result);

        return answer.stream().mapToInt(i->i).toArray();
    }

    public void AddProgresses(int[] progresses, int[] speeds) {
        for (int i=0; i <progresses.length; i++) {
            if (progresses[i] < 100) {
                progresses[i] += speeds[i];
            }
        }
    }
}
