package programmers;

/** Created By DevHyeon on 2020.11.25
 *  Question Title : 카펫
 *  Algorithm Type : BP
 *  Level : 2
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/42842
 * */
public class Lv2Sol42842 {
    /** yellow rect : x * y
     *  brown : yellow rect 의 테두리 1줄
     *  all rect : (yellow X + 2) * (yellow Y + 2)
     * */
    public int[] solution(int brown, int yellow) {

        int allRectSize = brown + yellow;
        int yellowWidth = yellow;
        int yellowHeight = 1;
        int yellowRect = yellowWidth * yellowHeight;

        while(true) {
            if ((yellowWidth * yellowHeight == yellowRect) && ((yellowWidth+2) * (yellowHeight+2) == allRectSize)) {
                break;
            } else {
                yellowHeight++;
                yellowWidth = yellowRect / yellowHeight;
            }
        }

        int[] answer = {(yellowWidth+2),(yellowHeight+2)};
        return answer;
    }
}
