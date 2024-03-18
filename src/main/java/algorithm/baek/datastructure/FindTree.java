package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11725
 * 트리의 부모 찾기
 */
public class FindTree implements TestCase {
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
//        Node root = new Node(1);
        parents = new int[n + 1];
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
//            makeTree(root, a, b);
        }

        dfs(1);

        for (int i = 2; i < n + 1; i++) {
            sb.append(parents[i]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void dfs(int node) {
        visited[node] = true;
        for(int next : tree[node]) {
            if(!visited[next]) {
                parents[next] = node;
                dfs(next);
            }
        }
    }

    public static void makeTree(Node root, int a, int b) {
        if (root == null) return;
        if (root.data == a) {
            if (root.left == null) {
                root.left = new Node(b);
                parents[b] = a;
            } else {
                root.right = new Node(b);
                parents[b] = a;
            }
        } else if (root.data == b) {
            if (root.left == null) {
                root.left = new Node(a);
                parents[a] = b;
            } else {
                root.right = new Node(a);
                parents[a] = b;
            }
        } else {
            makeTree(root.left, a, b);
            makeTree(root.right, a, b);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
