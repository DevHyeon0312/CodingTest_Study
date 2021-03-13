package programmers;

import java.util.ArrayList;

public class Lv2Sol42584 {
    public int[] solution(int[] prices) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i=0; i<prices.length; i++) {
            int target = prices[i];
            int time = 0;
            for(int j=i+1; j<prices.length; j++) {
                time++;
                if(target > prices[j]) {
                    break;
                }
            }
            answer.add(time);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
