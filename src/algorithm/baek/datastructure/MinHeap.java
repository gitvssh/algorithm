package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1927
 * 최소 힙
 */
public class MinHeap implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if (pq.isEmpty()) {
                    bw.write("0" + "\n");
                }else{
                    bw.write(pq.poll() + "\n");
                }
            }else{
                pq.add(x);
            }
        }
        bw.close();
    }
}
