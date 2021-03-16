package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lv2Sol42587 {
    public int solution(int[] priorities, int location) {
        //프린트 대기열 생성
        ArrayList<Integer> printList = new ArrayList<>();
        for (int print : priorities) {
            printList.add(print);
        }

        int answer = 0;
        int myPrint = location;
        while (true) {
            System.out.println("현재 대기열");
            for (int p : printList) {
                System.out.print(p+" ");
            }
            System.out.println("");

            int print = printList.get(0);
            System.out.println(print +"출력시도");
            boolean type = true;
            for (int j=1; j<printList.size(); j++) {
                if (print < printList.get(j)) {
                    printList.remove(0);
                    printList.add(print);
                    System.out.println(print +"뒤로가시오");
                    if (myPrint == 0) {
                        myPrint = printList.size();
                    }
                    type = false;
                    break;
                }
            }
            myPrint--;
            if (type) {
                printList.remove(0);
                answer++;
                System.out.println(print +"출력완료");
            }

            if (myPrint < 0) {
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }

}
