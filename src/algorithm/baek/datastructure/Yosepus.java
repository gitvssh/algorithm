package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Yosepus implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        bw.write("<");
        while(deque.size()>1) {
            for (int i = 0; i < k-1; i++) {
                deque.addLast(deque.pollFirst());
            }
            bw.write(deque.pollFirst() + ", ");
        }
        bw.write(deque.pollFirst() + ">");
        bw.close();
    }
}
