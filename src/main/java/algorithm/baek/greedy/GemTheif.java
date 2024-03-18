package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1202
 * 보석 도둑
 * greedy
 */
public class GemTheif implements TestCase {
    static int N, K;
    static int[] bags;
    static int[][] gems;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 보석의 개수
        K = Integer.parseInt(st.nextToken()); // 가방의 개수
        gems = new int[N][2];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken()); // 무게
            gems[i][1] = Integer.parseInt(st.nextToken()); // 가격
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방을 오름차순으로 정렬
        Arrays.sort(bags);
        // 보석을 무게를 기준으로 오름차순으로 정렬
        Arrays.sort(gems, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        // 가방에 보석을 담는다.
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && gems[j][0] <= bags[i]) {
                pq.add(gems[j++][1]);
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
