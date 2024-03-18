package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Deque;

public class Card1 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new java.util.ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }
        while (deque.size() > 1) {
            bw.write(deque.removeFirst() + " ");
            deque.addLast(deque.removeFirst());
        }
        bw.write(deque.removeFirst() + "\n");
        bw.close();
    }
}
