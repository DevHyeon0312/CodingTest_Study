package programmers;

public class Lv2Sol60057 {
    public int solution(String s) {
        int checkSize = s.length()/2+2;
        int min = s.length();
        for (int i=1; i<checkSize; i++) {
//            System.out.println(s+"를"+i+"사이즈로 자르기");
            int temp = checkLength(s,i);
            min = Math.min(temp, min);
        }

        System.out.println(min+"이 가장 짧습니다.");
        return min;
    }

    //문자열 s 를 size 로 자른경우 압축된결과문자열의 길이
    public int checkLength(String s, int size) {
//        System.out.println(s);
        String str = "";
        String start = s.substring(0, size);
        int count = 1;
        for (int i=size; i<s.length();i+=size) {
            System.out.println("가능위치:"+s.length());
            System.out.println("현재위치:"+i);
            System.out.println("다음위치:"+(i+size));
            //index 벗어남 체크
            if (i+size > s.length()) {
                str += count + "" + s.substring(i);
                count=1;
                break;
            }

            String temp = s.substring(i, i+size);

            if (start.equals(temp)) {
                count++;
            } else {
                str += count+""+start;
                start = temp;
                count=1;
            }
        }

        str += count+""+start;
        str = str.replaceAll("1","");

        System.out.println(size+"("+str.length()+"):"+str);
        return str.length();
    }
}
