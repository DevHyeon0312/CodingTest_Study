package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LvSol2178S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        ArrayGraph graph = new ArrayGraph(N, M);
        int d = 1;
        for (int i = 0; i < N; i++) {
            int[] data = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                if (data[j] != 0) {
                    graph.addEdge(i, j, d++);
                } else {
                    graph.addEdge(i, j, 0);
                }
            }
        }
        graph.BFS();
    }
    
    /** 인접배열 그래프 */
    static class ArrayGraph {
        /** 노드 */
        private class Node {
            int data;
            int n;
            int m;
            int count=0;
            boolean isVisit;

            public Node(int n, int m, int data) {
                this.n = n;
                this.m = m;
                this.data = data;
                this.isVisit = false;
            }
        }

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
                    nodes[r.n+1][r.m].count = r.count+1;
                    if(visitPrint(nodes[r.n+1][r.m])){
                        break;
                    }
                }
                //우
                else if(r.m+1 < nodes[r.n].length && !nodes[r.n][r.m+1].isVisit && nodes[r.n][r.m+1].data != 0) {
                    queue.add(nodes[r.n][r.m+1]);
                    nodes[r.n][r.m+1].isVisit = true;
                    nodes[r.n][r.m+1].count = r.count+1;
                    if(visitPrint(nodes[r.n][r.m+1])){
                        break;
                    }
                }
                //좌
                else if(r.m-1 >= 0 && !nodes[r.n][r.m-1].isVisit && nodes[r.n][r.m-1].data != 0) {
                    queue.add(nodes[r.n][r.m-1]);
                    nodes[r.n][r.m-1].isVisit = true;
                    nodes[r.n][r.m-1].count = r.count+1;
                    if (visitPrint(nodes[r.n][r.m-1])){
                        break;
                    }
                }
                //상
                else if(r.n-1 >= 0 && !nodes[r.n-1][r.m].isVisit && nodes[r.n-1][r.m].data != 0) {
                    queue.add(nodes[r.n-1][r.m]);
                    nodes[r.n-1][r.m].isVisit = true;
                    nodes[r.n-1][r.m].count = r.count+1;
                    if(visitPrint(nodes[r.n-1][r.m])) {
                        break;
                    }
                }
                //가능노드 없음 {
                else {
                    queue.poll();
                }
            }
        }

        boolean visitPrint(Node node) {
            if(node.data == nodes[nodes.length-1][nodes[0].length-1].data) {
                System.out.println(node.count+1);
                return true;
            } else {
                return false;
            }
        }
    }
}