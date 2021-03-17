package programmers;

import java.util.Arrays;

public class Lv1Sol42862 {
    public static void main(String[] args) {
        int n = 1;
        int[] lost = {1};
        int[] reserve = {};
        new Solution().solution(n,lost,reserve);
    }
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int arr[] = new int[n];

            for(int i : lost) {
                arr[i-1] = -1;
            }

            for (int i : reserve) {
                //내껀 내가 챙긴다. 빌려준놈들꺼 다 안받을거야.
                if(arr[i-1] != 0) {
                    arr[i-1] = 1;
                    continue;
                }

                //앞에놈이 안가져왔네?
                if(i-2 >= 0 && arr[i-2] == -1) {
                    //뒤에놈도 안가져왔네?
                    if(i < n && arr[i] == -1) {
                        //뒤에놈은 더 뒤에놈한테 받을 가능성은 존재하나
                        boolean backP = (i+1 < n && arr[i+1] == 0);
                        if(backP) {
                            //ㅇㅇ 앞에놈부터 챙겨
                            arr[i-2] = 2;
                        } else {
                            //ㄴㄴ 뒤에놈부터 챙겨줘
                            arr[i] = 3;
                        }
                    }
                    //뒤에놈은 가져왔네?
                    else {
                        //앞에놈 챙겨주자.
                        arr[i-2] = 2;
                    }
                }
                //앞에놈은 챙겼는데 뒤에놈은?
                else if(i < n && arr[i] == -1) {
                    arr[i] = 3;
                }
            }

            int count = (int) Arrays.stream(arr).filter(i->i!=-1).count();
            System.out.println(Arrays.toString(arr));
            System.out.println(count);
            return count;
        }
    }
}
