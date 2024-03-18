package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1991
 * 트리 순회
 */
public class TreeTraversal implements TestCase {
    static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
    static Node head = new Node('A', null, null);

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, root, left, right);
        }
        head.preOrder(head);
        bw.newLine();
        head.inOrder(head);
        bw.newLine();
        head.postOrder(head);
        bw.close();
    }

    public static void insertNode(Node head, char root, char left, char right) {
        if (head.getData() == root) {
            head.setLeft((left == '.' ? null : new Node(left, null, null)));
            head.setRight((right == '.' ? null : new Node(right, null, null)));
        } else {
            if (head.getLeft() != null) insertNode(head.getLeft(), root, left, right);
            if (head.getRight() != null) insertNode(head.getRight(), root, left, right);
        }
    }

    static class Node {
        private char data;
        private Node left;
        private Node right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


        public char getData() {
            return data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public static void preOrder(Node node) throws IOException {
            if (node == null) return;
            bw.write(node.getData());
            preOrder(node.left);
            preOrder(node.right);
        }

        public static void inOrder(Node node) throws IOException {
            if (node == null) return;
            inOrder(node.left);
            bw.write(node.getData());
            inOrder(node.right);
        }

        public static void postOrder(Node node) throws IOException {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            bw.write(node.getData());
        }
    }
}
