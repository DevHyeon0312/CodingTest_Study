package Algo_Bookmark;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFSListGraph {
    public static void main(String[] args) throws IOException {
        ListGraph listGraph = new ListGraph(4);
        listGraph.addEdge(1, 2);
        listGraph.addEdge(1, 3);
        listGraph.addEdge(2, 4);
        listGraph.addEdge(3, 4);
//        Graph graph = new Graph(5);
//        graph.addEdge(5,4);
//        graph.addEdge(5,2);
//        graph.addEdge(1,2);
//        graph.addEdge(3,4);
//        graph.addEdge(3,1);
//        Graph graph = new Graph(5);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(2, 5);
//        System.out.println(graph.toString());

        listGraph.DFS(1);
        System.out.println("");
        listGraph.visitClear();
        listGraph.BFS(1);
    }
}

/** 인접리스트 그래프 */
class ListGraph {
    /** 노드 */
    private class Node {
        int data;
        LinkedList<Node> link;
        boolean isVisit;

        public Node(int data) {
            this.data = data;
            this.link = new LinkedList<>();
            this.isVisit = false;
        }

        @Override
        public String toString() {
            String str = "\n        NODE{data="+data+", isVisit="+isVisit+", Link=[ ";
            for (Node node : link) {
                str += node.data+" ";
            }
            str+="]}\n";
            return str;
        }
    }

    Node[] nodes;
    private ListGraph(){}
    public ListGraph(int size) {
        nodes = new Node[size+1];
        for (int i=0; i<=size; i++) {
            nodes[i] = new Node(i);
        }
    }
    public void visitClear() {
        for (Node node : nodes) {
            node.isVisit = false;
        }
    }

    /** 노드 연결 */
    void addEdge(int i1, int i2) {
        Node node1 = nodes[i1];
        Node node2 = nodes[i2];
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
        Node root = nodes[startIndex];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.isVisit = true;
        visitPrint(root);
        while (!stack.isEmpty()) {
            Node r = stack.peek();
            Node nextNode = null;
            /** 방문의 조건은 늘 바뀔 수 있다. */
            for (Node n : r.link) {
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
        Node root = nodes[startIndex];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.isVisit = true;
        visitPrint(root);
        while (!queue.isEmpty()) {
            Node r = queue.peek();
            Node nextNode = null;
            /** 방문의 조건은 늘 바뀔 수 있다. */
            for (Node n : r.link) {
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

    void visitPrint(Node node) {
        System.out.print(node.data+" ");
    }
}
