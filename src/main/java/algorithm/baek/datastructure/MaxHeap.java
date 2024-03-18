package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/11279
 * 최대 힙
 */
public class MaxHeap implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) > Math.abs(o2)) {
                return Math.abs(o1) - Math.abs(o2);
            } else if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return -1;
            }
        });
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    bw.write("0");
                    bw.newLine();
                } else {
                    bw.write(pq.poll() + "");
                    bw.newLine();
                }
            } else {
                pq.add(x);
            }
        }
        bw.close();
    }
}
