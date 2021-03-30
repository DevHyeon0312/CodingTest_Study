package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LvSol1260S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        int V = input[2];
        Graph graph = new Graph(N);
        for (int i=0; i<M; i++) {
            int[] data = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.addEdge(data[0],data[1]);
        }

        graph.DFS(V);
        System.out.println("");
        graph.visitClear();
        graph.BFS(V);
    }
}
/** 인접리스트 그래프 */
class Graph {
    /** 노드 */
    private class Node {
        int data;
        LinkedList<Graph.Node> link;
        boolean isVisit;

        public Node(int data) {
            this.data = data;
            this.link = new LinkedList<>();
            this.isVisit = false;
        }

        @Override
        public String toString() {
            String str = "\n        NODE{data="+data+", isVisit="+isVisit+", Link=[ ";
            for (Graph.Node node : link) {
                str += node.data+" ";
            }
            str+="]}\n";
            return str;
        }
    }

    Graph.Node[] nodes;
    private Graph(){}
    public Graph(int size) {
        nodes = new Graph.Node[size+1];
        for (int i=0; i<=size; i++) {
            nodes[i] = new Graph.Node(i);
        }
    }
    public void visitClear() {
        for (Graph.Node node : nodes) {
            node.isVisit = false;
        }
    }

    /** 노드 연결 */
    void addEdge(int i1, int i2) {
        Graph.Node node1 = nodes[i1];
        Graph.Node node2 = nodes[i2];
        if(!node1.link.contains(node2)){
            node1.link.add(node2);
        }
        if(!node2.link.contains(node1)){
            node2.link.add(node1);
        }
    }

    @Override
    public String toString() {
        return "Graph{\n" +
                "nodes=" + Arrays.toString(nodes) +
                "}";
    }


    void DFS() {
        DFS(0);
    }
    void DFS(int startIndex) {
        Graph.Node root = nodes[startIndex];
        Stack<Graph.Node> stack = new Stack<>();
        stack.push(root);
        root.isVisit = true;
        visitPrint(root);
        while (!stack.isEmpty()) {
            Graph.Node r = stack.peek();
            Graph.Node nextNode = null;
            /** 방문의 조건은 늘 바뀔 수 있다. */
            for (Graph.Node n : r.link) {
                if (!n.isVisit) {
                    if(nextNode==null) {
                        nextNode = n;
                    } else {
                        nextNode = nextNode.data > n.data ? n : nextNode;
                    }
                }
            }
            if (nextNode!=null) {
                nextNode.isVisit = true;
                stack.push(nextNode);
                visitPrint(nextNode);
            } else {
                stack.pop();
            }
        }
    }

    void BFS() {
        BFS(0);
    }
    void BFS(int startIndex) {
        Graph.Node root = nodes[startIndex];
        Queue<Graph.Node> queue = new LinkedList<>();
        queue.add(root);
        root.isVisit = true;
        visitPrint(root);
        while (!queue.isEmpty()) {
            Graph.Node r = queue.peek();
            Graph.Node nextNode = null;
            /** 방문의 조건은 늘 바뀔 수 있다. */
            for (Graph.Node n : r.link) {
                if (!n.isVisit) {
                    if(nextNode==null) {
                        nextNode = n;
                    } else {
                        nextNode = nextNode.data > n.data ? n : nextNode;
                    }
                }
            }
            if (nextNode!=null) {
                nextNode.isVisit = true;
                queue.add(nextNode);
                visitPrint(nextNode);
            } else {
                queue.poll();
            }
        }
    }

    void visitPrint(Graph.Node node) {
        System.out.print(node.data+" ");
    }
}
