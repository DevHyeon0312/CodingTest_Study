package programmers;

import java.util.*;

/** Created By DevHyeon on 2020.11.18
 *  Question Title : 두 개 뽑아서 더하기
 *  Algorithm Type : Brute-Force
 *  Level : 1
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/68644
 * */
public class Lv1TwoPlus {
    public int[] solution(int[] numbers) {
        List<Integer> numberArr = new ArrayList<>();
        for (int i=0; i<numbers.length; i++) {
            for (int j=0; j<numbers.length;j++) {
                if (i == j) {
                    continue;
                }
                int num = numbers[i]+numbers[j];
                if (!numberArr.contains(num)) {
                    numberArr.add(num);
                }
            }
        }

        Collections.sort(numberArr);
        return convertIntegers(numberArr);
    }

    public int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next();
        }
        return ret;
    }
}
