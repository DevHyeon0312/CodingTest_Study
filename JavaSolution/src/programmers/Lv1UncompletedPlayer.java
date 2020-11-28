package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/** Created By DevHyeon on 2020.11.18
 *  Question Title : 완주하지 못한 선수
 *  Algorithm Type : Hash
 *  Level : 1
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/42576
 * */
public class Lv1UncompletedPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> map = new HashMap();

        for(String s : participant){
            if(map.containsKey(s))
                map.put(s,map.get(s)+1);
            else{
                map.put(s,1);
            }
        }

        for(String s : completion){
            if(map.containsKey(s))
                map.put(s,map.get(s)-1);
            if(map.get(s)==0)
                map.remove(s);
        }
        Set set = map.keySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            String key = (String)iterator.next();
            answer = answer + key +',';
        }
        answer = answer.substring(0,answer.length()-1);
        return answer;
    }
}
