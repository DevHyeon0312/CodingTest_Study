package programmers;

import java.util.HashMap;

public class Lv2Sol67256 {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        //LRLLLRLLRRL
        System.out.println(solution(array,hand));
    }
    static public String solution(int[] numbers, String hand) {
        StringBuilder builder = new StringBuilder();
        /** Create TouchPAD */
        HashMap<Integer, NUMBER> hashMap = new HashMap<>();
        int number = 1;
        for (int i=0; i<3;i++) {
            for (int j=0; j<3; j++) {
                hashMap.put(number++,new NUMBER(i,j));
            }
        }
        hashMap.put(10,new NUMBER(3,0));
        hashMap.put(0,new NUMBER(3,1));
        hashMap.put(11,new NUMBER(3,2));

        /** Init Hand Location */
        NUMBER leftHand = hashMap.get(10);
        NUMBER rightHand = hashMap.get(11);

        /** Play Touch */
        for (int num : numbers) {
            //반드시 왼손
            if(num==1||num==4||num==7) {
                leftHand = hashMap.get(num);
                builder.append("L");
            }
            //반드시 오른손
            else if(num==3||num==6||num==9) {
                rightHand = hashMap.get(num);
                builder.append("R");
            }
            //더 가까운 손
            else {
                //점과 점사이의 거리
                NUMBER mid = hashMap.get(num);
                int leftABS = Math.abs(leftHand.x - mid.x) + Math.abs(leftHand.y - mid.y);
                int rightABS = Math.abs(rightHand.x - mid.x) + Math.abs(rightHand.y - mid.y);
                //오른손이 더 가까움
                if(leftABS > rightABS) {
                    rightHand = mid;
                    builder.append("R");
                }
                //왼손이 더 가까움
                else if(leftABS < rightABS) {
                    leftHand = mid;
                    builder.append("L");
                }
                //동일한거리
                else {
                    //왼손잡이
                    if(hand.equals("left")) {
                        leftHand = mid;
                        builder.append("L");
                    }
                    //오른손잡이
                    else {
                        rightHand = mid;
                        builder.append("R");
                    }
                }
            }
        }

        return builder.toString();
    }
    static class NUMBER {
        int x;
        int y;
        public NUMBER(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
