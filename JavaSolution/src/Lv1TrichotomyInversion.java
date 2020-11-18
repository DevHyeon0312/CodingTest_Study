import java.lang.*;

/** Created By DevHyeon on 2020.11.18
 *  Question Title : 3진법 뒤집기
 *  Algorithm Type : Implementation
 *  Level : 1
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/68935
 * */
class Lv1TrichotomyInversion {
    public int solution(int n) {
        String number = toDeposition(n, 3);
        String reverse = new StringBuffer(number).reverse().toString();
        int answer = Integer.parseInt(reverse, 3);

        return answer;
    }

    public String toDeposition(int value, int i){
        String returnString = "";
        String temp = "";
        while(value != 0){
            if( (value % i) < 10 ) {
                returnString = (value % i) + returnString;
                value /= i;
            }
            else {
                int temp1 = (char)((value % i)  + 55);
                returnString = Integer.toString(temp1) + returnString;
            }
        }
        return returnString;
    }
}