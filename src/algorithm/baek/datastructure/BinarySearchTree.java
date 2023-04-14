package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/5639
 * 이진 검색 트리
 */
public class BinarySearchTree implements TestCase {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> preorder = new ArrayList<>();

    @Override
    public void test() throws ParseException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            preorder.add(Integer.parseInt(input));
        }

        List<Integer> postorder = getPostorder(preorder);
        for (int val : postorder) {
            sb.append(val).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static List<Integer> getPostorder(List<Integer> preorder) {
        if (preorder.isEmpty()) {
            return new ArrayList<>();
        }

        int root = preorder.get(0);
        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();

        for (int val : preorder.subList(1, preorder.size())) {
            if (val < root) {
                leftSubtree.add(val);
            } else {
                rightSubtree.add(val);
            }
        }

        List<Integer> postorder = new ArrayList<>();
        postorder.addAll(getPostorder(leftSubtree));
        postorder.addAll(getPostorder(rightSubtree));
        postorder.add(root);

        return postorder;
    }
}
