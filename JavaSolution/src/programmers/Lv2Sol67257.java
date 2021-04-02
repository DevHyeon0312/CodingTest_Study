package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Lv2Sol67257 {
    public static void main(String[] args) {
        String expr = "100-200*300-500+20";
        //6083974714
        System.out.println(solution(expr));
    }
    static public long solution(String expression) {
        /** 입력된 문자열을 숫자와 연산자로 분리 */
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<expression.length();i++) {
            char c = expression.charAt(i);
            if(48 <= c && 57 >= c) {
                builder.append(c);
            } else {
                arrayList.add(builder.toString());
                builder = new StringBuilder();
                builder.append(c);
                arrayList.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        arrayList.add(builder.toString());

        /** 각 연산에 따른 결과값 (우선순위에 맞게 콜) */
        long type1 = Math.abs(Long.parseLong(getExpr(getExpr(getExpr(arrayList,"*"),"+"),"-").get(0)));
        long type2 = Math.abs(Long.parseLong(getExpr(getExpr(getExpr(arrayList,"*"),"-"),"+").get(0)));
        long type3 = Math.abs(Long.parseLong(getExpr(getExpr(getExpr(arrayList,"+"),"*"),"-").get(0)));
        long type4 = Math.abs(Long.parseLong(getExpr(getExpr(getExpr(arrayList,"+"),"-"),"*").get(0)));
        long type5 = Math.abs(Long.parseLong(getExpr(getExpr(getExpr(arrayList,"-"),"*"),"+").get(0)));
        long type6 = Math.abs(Long.parseLong(getExpr(getExpr(getExpr(arrayList,"-"),"+"),"*").get(0)));

        return Math.max(Math.max(Math.max(Math.max(Math.max(type1,type2),type3),type4),type5),type6);
    }

    /** 해당 연산자를 만나면 계산 */
    static public ArrayList<String> getExpr(ArrayList<String> expression, String a1) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(Arrays.toString(expression.toArray()));
        boolean isExpr = false;
        String temp = "";
        for (int i=0; i<expression.size();i++) {
            if(expression.get(i).equals(a1)) {
                isExpr = true;
                temp = arrayList.get(arrayList.size()-1);
                arrayList.remove(arrayList.size()-1);
            }
            if(isExpr) {
                if (expression.get(i).equals("*")) {
                    arrayList.add(Long.parseLong(temp) * Long.parseLong(expression.get(i+1))+"");
                } else if(expression.get(i).equals("+")) {
                    arrayList.add(Long.parseLong(temp) + Long.parseLong(expression.get(i+1))+"");
                } else {
                    arrayList.add(Long.parseLong(temp) - Long.parseLong(expression.get(i+1))+"");
                }
                isExpr = false;
                i++;
            } else {
                arrayList.add(expression.get(i));
            }
        }
        return arrayList;
    }
}
