package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/28018
 * 도서관
 * 누적합
 */
public class Library implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] seats = new int[1000002];  // 각 시간에 사용중인 좌석 수
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            seats[start]++;
            seats[end+1]--;
        }

        // 누적합 구하기
        for (int i = 1; i < seats.length; i++) {
            seats[i] += seats[i - 1];
        }

        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(st.nextToken());
            bw.write(seats[query] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
