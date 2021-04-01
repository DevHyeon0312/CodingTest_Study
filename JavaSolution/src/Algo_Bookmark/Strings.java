package Algo_Bookmark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("답["+stringReverse("zzz")+"]");

        String[] strings = {"abce", "abcd", "cdx"};
        System.out.println(Arrays.toString(reverseSortN(strings,1)));

        System.out.println(isOnlyNumber("123"));
        System.out.println(isOnlyNumber("a123"));
        System.out.println(isOnlyNumber("1a23"));
        System.out.println(isOnlyNumber("12a3"));
        System.out.println(isOnlyNumber("123a"));
        System.out.println(isOnlyNumber("0"));

        String[] arr = {"Dev","Alpha","Zibra","Jane", "Kim"};
        StringBuilder builder = new StringBuilder();
        System.out.println(getStringIndex(arr,"Kim"));

        String str = "123123123123";
        str = str.replaceAll("\\w(?=\\w{4})", "*");
        System.out.println(str);
    }

    /** 문자열 뒤집기 */
    static String stringReverse(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        return builder.reverse().toString();
    }

    /** 문자열 역순 정렬 (대문자는 소문자보다 작다고 가정) */
    static String reversSort(String s) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(s.split("")).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) < o2.charAt(0)) {
                    return 1;
                } else if(o1.charAt(0)>o2.charAt(0)) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }).forEach(c -> builder.append(c));
        return builder.toString();
    }

    /** n번째 인덱스로 문자열배열을 정렬하기 */
    static String[] reverseSortN(String[] str, int n) {
        String[] strings = str;
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)) {
                    return 1;
                } else if(o1.charAt(n) < o2.charAt(n)) {
                    return -1;
                }else {
                    return o1.compareTo(o2);
                }
            }
        });
        return strings;
    }

    /** 문자열이 숫자로만 이루어졌는지 확인 */
    static boolean isOnlyNumber(String s) {
        //공백은 true 반환.
        return s.matches("^[0-9]*");
    }

    /** 문자열이 시작되는 인덱스 찾기 */
    static int getStringIndex(String[] strings, String target) {
        int n = LowerBound(strings,target);
        System.out.println(n);
        return n;
    }

    /** 정렬된 문자열배열에서 문자열 찾기 (2진탐색) */
    public static int LowerBound(String[] array, String target) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int low = 0;
        int high = array.length;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low)/2;
            if (target.compareTo(array[mid]) < 0) {
                high = mid;
            } else if (target.compareTo(array[mid]) > 0) {
                low = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }

    /** 문자열 마지막 4자리까지 mask 처리 */
    public static String getStringMask(String str) {
        return str.replaceAll("\\w(?=\\w{4})", "*");
        // 동일기능
        //return str.replaceAll(".(?=.{4})", "*");
    }
}
