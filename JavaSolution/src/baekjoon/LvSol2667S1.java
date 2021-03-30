package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LvSol2667S1 {
    static int count = 0;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Node> searchList = new ArrayList<>();
        ArrayGraph graph = new ArrayGraph(N, N);
        int d = 1;
        for (int i = 0; i < N; i++) {
            int[] data = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (data[j] != 0) {
                    graph.addEdge(i, j, d++);
                    searchList.add(graph.nodes[i][j]);
                } else {
                    graph.addEdge(i, j, 0);
                }
            }
        }
        for (Node node : searchList) {
            if(!node.isVisit) {
                graph.BFS(node.n,node.m);
                arrayList.add(count);
                count = 0;
            }
        }

        System.out.println(arrayList.size());
        for (int i : arrayList.stream().sorted().mapToInt(i->i).toArray()) {
            System.out.println(i);
        }
    }


    /** 노드 */
    static class Node {
        int data;
        int n;
        int m;
        boolean isVisit;

        public Node(int n, int m, int data) {
            this.n = n;
            this.m = m;
            this.data = data;
            this.isVisit = false;
        }
    }

    /** 인접배열 그래프 */
    static class ArrayGraph {

        Node[][] nodes;
        private ArrayGraph(){}
        public ArrayGraph(int n, int m) {
            this.nodes = new Node[n][m];
        }
        void addEdge(int n, int m, int data) {
            this.nodes[n][m] = new Node(n,m,data);
        }
        void BFS() {
            BFS(0,0);
        }
        void BFS(int n, int m) {
            Node root = nodes[n][m];
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.isVisit = true;
            visitPrint(root);
            while (!queue.isEmpty()) {
                Node r = queue.peek();
                /** 방문의 조건은 늘 바뀔 수 있다. */
                //하
                if (r.n+1 < nodes.length && !nodes[r.n+1][r.m].isVisit && nodes[r.n+1][r.m].data != 0) {
                    queue.add(nodes[r.n+1][r.m]);
                    nodes[r.n+1][r.m].isVisit = true;
                    visitPrint(nodes[r.n+1][r.m]);
                }
                //우
                else if(r.m+1 < nodes[r.n].length && !nodes[r.n][r.m+1].isVisit && nodes[r.n][r.m+1].data != 0) {
                    queue.add(nodes[r.n][r.m+1]);
                    nodes[r.n][r.m+1].isVisit = true;
                    visitPrint(nodes[r.n][r.m+1]);
                }
                //좌
                else if(r.m-1 >= 0 && !nodes[r.n][r.m-1].isVisit && nodes[r.n][r.m-1].data != 0) {
                    queue.add(nodes[r.n][r.m-1]);
                    nodes[r.n][r.m-1].isVisit = true;
                    visitPrint(nodes[r.n][r.m-1]);
                }
                //상
                else if(r.n-1 >= 0 && !nodes[r.n-1][r.m].isVisit && nodes[r.n-1][r.m].data != 0) {
                    queue.add(nodes[r.n-1][r.m]);
                    nodes[r.n-1][r.m].isVisit = true;
                    visitPrint(nodes[r.n-1][r.m]);
                }
                //가능노드 없음 {
                else {
                    queue.poll();
                }
            }
        }

        void visitPrint(Node node) {
            count++;
        }

        void graphPrint() {
            for (int i=0; i<nodes.length;i++) {
                for (int j=0; j<nodes[i].length;j++) {
                    System.out.printf("%02d ",nodes[i][j].data);
                }
                System.out.println("");
            }
        }
    }
}