package programmers;

/** Created By DevHyeon on 2020.11.20
 *  Question Title : 내적
 *  Algorithm Type : Implementation
 *  Level : 1
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/70128
 * */
public class Lv1Internal {
    public class Solution {
        public int solution(int[] a, int[] b) {

            long temp = 0;
            for (int size = 0 ; size < a.length; size++) {
                temp += a[size] * b[size];
            }
            int answer = (int)temp;
            return answer;
        }
    }
}
