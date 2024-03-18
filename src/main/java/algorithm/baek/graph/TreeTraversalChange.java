package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2263
 * 트리의 순회
 * 트리, 분할 정복
 */
public class TreeTraversalChange implements TestCase {
    static int[] inOrder;
    static int[] postOrder;
    static int[] position;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
    public void test() throws ParseException, IOException {
        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        position = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            position[inOrder[i]] = i;
        }
        preOrder(0, n - 1, 0, n - 1);
        bw.close();
    }

    private void preOrder(int is, int ie, int ps, int pe) throws IOException {
        if (is > ie || ps > pe) return;
        int root = postOrder[pe];
        bw.write(root + " ");
        int inRoot = position[root];
        int left = inRoot - is;
        preOrder(is, inRoot - 1, ps, ps + left - 1);
        preOrder(inRoot + 1, ie, ps + left, pe - 1);
    }
}
