package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class MyQueue implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(deque.isEmpty() ? "-1" : deque.pollFirst() + "");
                    bw.newLine();
                    break;
                case "size":
                    bw.write(deque.size() + "");
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(deque.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "front":
                    bw.write(deque.isEmpty() ? "-1" : deque.peekFirst() + "");
                    bw.newLine();
                    break;
                case "back":
                    bw.write(deque.isEmpty() ? "-1" : deque.peekLast() + "");
                    bw.newLine();
                    break;
            }
        }
        bw.close();
    }
}
