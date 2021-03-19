package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LvSol7568S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        People[] array = new People[N];
        for(int i=0; i<N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            array[i] = new People(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }

        for (int i=0; i<N; i++) {
            for(int j=(i+1); j<N;j++) {
                if(array[i].p > array[j].p && array[i].q > array[j].q) {
                    array[j].up();
                } else if(array[i].p < array[j].p && array[i].q < array[j].q) {
                    array[i].up();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (People people : array) {
            builder.append(people.number).append(" ");
        }
        System.out.println(builder.toString());
    }

    static class People {
        public int p; //키
        public int q; //몸무게
        public int number;
        public People(int p, int q) {
            this.p = p;
            this.q = q;
            this.number = 1;
        }

        public void up() {
            this.number++;
        }
    }
}
