import java.util.*;

/** Created By DevHyeon on 2020.11.19
 *  Question Title : 나누어 떨어지는 숫자 배열
 *  Algorithm Type : Implementation
 *  Level : 1
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/12910
 * */
class Lv1SplittingNumber {
    public int[] solution(int[] arr, int divisor) {
        int[] answer ={-1};
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : arr){
            if(i%divisor==0)
                list.add(i);
        }

        if(!list.isEmpty()){
            list.sort(null);
            answer = new int[list.size()];
            for(int i=0; i<list.size();i++){
                answer[i]=list.get(i);
            }
        }

        return answer;
    }
}