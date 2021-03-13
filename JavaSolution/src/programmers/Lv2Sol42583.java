package programmers;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2Sol42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>();

        System.out.println("시간 | 다리를 지나는 중");

        int time = 0;
        for (int i=0; i<truck_weights.length; i++) {
            Truck truck = new Truck(truck_weights[i]);
            time++;
            pop(queue, bridge_length);
            if (!push(time, queue, truck, weight)) {
                i--;
            }
        }


        System.out.println("END INPUT:"+(time));

        while (!queue.isEmpty()) {
            time++;
            pop(queue, bridge_length);
            print(time,queue);
        }

        int answer = time;
        System.out.println("END TIME:"+(answer));
        return answer;
    }

    // Queue 에 들어온 트럭
    class Truck {
        int length; //트럭 길이
        int weight; //트럭 무게
        public Truck(int truck_weight) {
            length = 1;
            weight = truck_weight;
        }
    }


    public boolean push(int time, Queue<Truck> queue, Truck truck ,int weight) {
        //push 조건 : 트럭무게 합 <= 다리무게
        int w = 0;
        for (Truck t : queue) {
            w += t.weight;
        }

        w += truck.weight;
        if (w > weight) {
            print(time, queue);
            return false;
        } else {
            queue.add(truck);
            print(time, queue);
            return true;
        }
    }

    public boolean pop(Queue<Truck> queue, int bridge_length) {
        //pop 조건 : 건넌길이 < 트럭길이 + 다리길이
        if (queue.isEmpty()) return false;

        if (queue.peek().length >= bridge_length) {
            queue.remove();
            for (Truck t : queue) {
                t.length++;
            }
            return true;
        } else {
            for (Truck t : queue) {
                t.length++;
            }
            return false;
        }
    }

    public void print(int time, Queue<Truck> queue) {
        System.out.print(time +"s : ");
        for (Truck t : queue) {
            System.out.print(t.weight +", ");
        }
        System.out.println("");
    }
}
