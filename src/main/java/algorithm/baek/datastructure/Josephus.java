package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1158
 * 요세푸스 문제
 * 자료구조
 */
public class Josephus implements TestCase {
    static int N, K;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //사람 수
        K = Integer.parseInt(st.nextToken()); //제거할 사람의 번호
        int[] arr = new int[N];
        bw.write("<");
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }
        int idx = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.add(q.poll());
            }
            bw.write(q.poll() + "");
            if (!q.isEmpty()) bw.write(", ");
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
