import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Create Solution Project");

        // Lv1TwoPlus.java
        int[] lv1TwoPlusNumbers = {2,1,3,4,1};
        int[] lv1TwoPlusResult = new Lv1TwoPlus().solution(lv1TwoPlusNumbers);
        for (int i : lv1TwoPlusResult) { System.out.print(i+" "); }
    }
}
