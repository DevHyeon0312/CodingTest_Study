package Algo_Bookmark;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
4 6
101111
101010
101011
111011
* */
public class BFSDFSArrayGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        ArrayGraph graph = new ArrayGraph(N,M);
        int d = 1;
        for (int i=0; i<N; i++) {
            int[] data = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j<M;j++) {
                if(data[j] != 0) {
                    graph.addEdge(i,j,d++);
                } else {
                    graph.addEdge(i,j,0);
                }
            }
        }
        System.out.println("----------그래프 모양----------");
        graph.graphPrint();
        System.out.println();
        System.out.println("----------DFS----------");
        graph.DFS();
        graph.visitClear();
        System.out.println();
        System.out.println("----------BFS----------");
        graph.BFS();
    }
}

/** 인접배열 그래프 */
class ArrayGraph {
    /** 노드 */
    private class Node {
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

    Node[][] nodes;
    private ArrayGraph(){}
    public ArrayGraph(int n, int m) {
        this.nodes = new Node[n][m];
    }
    void addEdge(int n, int m, int data) {
        this.nodes[n][m] = new Node(n,m,data);
    }
    void graphPrint() {
        for (int i=0; i<nodes.length;i++) {
            for (int j=0; j<nodes[i].length;j++) {
                System.out.printf("%02d ",nodes[i][j].data);
            }
            System.out.println("");
        }
    }

    public void visitClear() {
        for (Node[] node : nodes) {
            for (Node n : node) {
                n.isVisit = false;
            }
        }
    }

    void DFS() {
        DFS(0,0);
    }
    void DFS(int n, int m) {
        Node root = nodes[n][m];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.isVisit = true;
        visitPrint(root);
        while (!stack.isEmpty()) {
            Node r = stack.peek();
            /** 방문의 조건은 늘 바뀔 수 있다. */
            //하
            if (r.n+1 < nodes.length && !nodes[r.n+1][r.m].isVisit && nodes[r.n+1][r.m].data != 0) {
                stack.push(nodes[r.n+1][r.m]);
                nodes[r.n+1][r.m].isVisit = true;
                visitPrint(nodes[r.n+1][r.m]);
            }
            //우
            else if(r.m+1 < nodes[r.n].length && !nodes[r.n][r.m+1].isVisit && nodes[r.n][r.m+1].data != 0) {
                stack.push(nodes[r.n][r.m+1]);
                nodes[r.n][r.m+1].isVisit = true;
                visitPrint(nodes[r.n][r.m+1]);
            }
            //상
            else if(r.n-1 >= 0 && !nodes[r.n-1][r.m].isVisit && nodes[r.n-1][r.m].data != 0) {
                stack.push(nodes[r.n-1][r.m]);
                nodes[r.n-1][r.m].isVisit = true;
                visitPrint(nodes[r.n-1][r.m]);
            }
            //좌
            else if(r.m-1 >= 0 && !nodes[r.n][r.m-1].isVisit && nodes[r.n][r.m-1].data != 0) {
                stack.push(nodes[r.n][r.m-1]);
                nodes[r.n][r.m-1].isVisit = true;
                visitPrint(nodes[r.n][r.m-1]);
            }
            //가능노드 없음 {
            else {
                stack.pop();
            }
        }
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
            //상
            else if(r.n-1 >= 0 && !nodes[r.n-1][r.m].isVisit && nodes[r.n-1][r.m].data != 0) {
                queue.add(nodes[r.n-1][r.m]);
                nodes[r.n-1][r.m].isVisit = true;
                visitPrint(nodes[r.n-1][r.m]);
            }
            //좌
            else if(r.m-1 >= 0 && !nodes[r.n][r.m-1].isVisit && nodes[r.n][r.m-1].data != 0) {
                queue.add(nodes[r.n][r.m-1]);
                nodes[r.n][r.m-1].isVisit = true;
                visitPrint(nodes[r.n][r.m-1]);
            }
            //가능노드 없음 {
            else {
                queue.poll();
            }
        }
    }

    void visitPrint(Node node) {
        System.out.print(node.data+" ");
    }
}