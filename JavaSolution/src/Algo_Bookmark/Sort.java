package Algo_Bookmark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(isOrder(input)?"오름차순":isReverseOrder(input)?"내림차순":"정렬안됨");

    }

    /** 오름차순인지 확인 */
    static boolean isOrder(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }

    /** 내림차순인지 확인 */
    static boolean isReverseOrder(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] < array[i + 1]);
    }

    /** 문자열정렬 : 길이순 -> 알파벳순*/
    static void sortString(ArrayList<String> strings) {
        List<String> list = strings.stream().distinct().collect(Collectors.toList());
        list.stream().distinct().collect(Collectors.toList()).sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                } else if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return -1;
            }
        });
    }
    /** 문자열정렬 : 길이순 -> 알파벳순*/
    static void sortString(String[] strings) {
        List<String> list = Arrays.stream(strings).distinct().collect(Collectors.toList());
        list.stream().distinct().collect(Collectors.toList()).sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                } else if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return -1;
            }
        });
    }
}
