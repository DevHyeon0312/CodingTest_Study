import java.util.*;

/** Created By DevHyeon on 2020.11.19
 *  Question Title : 같은 숫자는 싫어
 *  Algorithm Type : Implementation
 *  Level : 1
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/12906
 * */
public class Lv1DontLikeSameNumber {
    public int[] solution(int []arr) {
        int num=-1;
        ArrayList list = new ArrayList<>();
        for(int i : arr) {
            if(num!=i) {
                list.add(i);
                num=i;
            }
        }

        int [] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = (int) list.get(i);
        }
        return answer;
    }
}