import java.util.*;
/** Created By DevHyeon on 2020.11.23
 *  Question Title : 호텔 방 배정
 *  Algorithm Type : Hash
 *  Level : 4
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/64063
 * */
public class Lv4Sol64063 {
    private HashMap<Long,Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] result = room_number;

        for (int i=0; i<room_number.length; i++) {
            result[i] = find(room_number[i]);
        }

        return result;
    }

    private long find(long room) {
        if(!map.containsKey(room)) {
            map.put(room, room+1);
            return room;
        } else {
            long next = map.get(room);
            long empty = find(next);
            map.put(room,empty);
            return empty;
        }
    }
}
