package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Lv1Sol42576 {

    public static void main(String[] args) {
//        String [] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String [] completion = {"josipa", "filipa", "marina", "nikola"};

        String [] participant = {"mislav", "stanko", "mislav", "ana"};
        String [] completion = {"stanko", "ana", "mislav"};
        System.out.println(new Lv1Sol42576.Solution().solution(participant, completion));
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            participant = Arrays.stream(participant).sorted().toArray(String[]::new);
            completion = Arrays.stream(completion).sorted().toArray(String[]::new);

            for (int i=0; i<completion.length; i++) {
                if(!participant[i].equals(completion[i])) {
                    return participant[i];
                }
            }

            return participant[participant.length-1];
        }
    }
}
