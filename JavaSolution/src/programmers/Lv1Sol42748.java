package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1Sol42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = 	{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(new Solution().solution(array, commands)));
    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int[] arr : commands) {
                ArrayList<Integer> list = new ArrayList<>();
                int start = arr[0]-1;
                int end = arr[1];
                if (start == end) {
                    list.add(array[start]);
                } else {
                    for(int i=start; i<end; i++) {
                        list.add(array[i]);
                    }
                }

                if(!list.isEmpty()) {
                    arrayList.add(list.stream().sorted().mapToInt(i->i).toArray()[arr[2]-1]);
                }
            }

            return arrayList.stream().mapToInt(i->i).toArray();
        }
    }
}
