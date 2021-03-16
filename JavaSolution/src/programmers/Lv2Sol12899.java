package programmers;

public class Lv2Sol12899 {
    public String solution(int n) {

        System.out.println(CHECK(1+""));
        System.out.println("--------------");
        System.out.println(CHECK(2+""));
        System.out.println("--------------");
        System.out.println(CHECK(3+""));
        System.out.println("--------------");
        System.out.println(CHECK(4+""));
        System.out.println("--------------");
        System.out.println(CHECK(5+""));
        System.out.println("--------------");
        System.out.println(CHECK(6+""));
        System.out.println("--------------");
        System.out.println(CHECK(7+""));
        System.out.println("--------------");
        System.out.println(CHECK(8+""));
        System.out.println("--------------");
        System.out.println(CHECK(9+""));
        System.out.println("--------------");
        System.out.println(CHECK(10+""));
        System.out.println("--------------");
        System.out.println(CHECK(11+""));
        System.out.println("--------------");
        System.out.println(CHECK(12+""));
        System.out.println("--------------");
        System.out.println(CHECK(13+""));
        System.out.println("--------------");
        System.out.println(CHECK(14+""));
        System.out.println("--------------");
        System.out.println(CHECK(15+""));
        System.out.println("--------------");


        String answer = "";
        return answer;
    }

    public String CHECK(String n) {
        long X = Long.parseLong(n)/3;
        long Y = Long.parseLong(n)%3;

        System.out.println("CHECK START (n) : "+n);

        long start = 0;
        long end = Y == 0 ? 4 : Y == 1 ? 1 : 2;

        if(n.equals("1") || n.equals("2") || n.equals("3")) {
            return end+"";
        }
        if(X==0) {
            return  start +""+ end;
        }
        if (Y == 0) {
            start = Long.parseLong(CHECK((X-1)+""));
        } else {
            start = Long.parseLong(CHECK((X+"")));
        }

        return  start +""+ end;
    }
}
