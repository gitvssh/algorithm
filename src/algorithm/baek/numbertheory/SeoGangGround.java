package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14938
 * 서강그라운드
 * 플로이드 와샬
 */
public class SeoGangGround implements TestCase {
    static int N, M, R;
    static int[] items;
    static ArrayList<ArrayList<Position>> arr;
    static int[] dist;
    static boolean[] check;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 지역의 개수
        M = Integer.parseInt(st.nextToken()); // 수색 범위
        R = Integer.parseInt(st.nextToken()); // 길의 개수

        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=1; i<=R; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Position(end, weight));
            arr.get(end).add(new Position(start, weight));
        }

        dist = new int[N + 1];
        check = new boolean[N + 1];

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dijkstra(i));
        }
        bw.write(String.valueOf(max));
        bw.close();

    }

    private int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);
        dist[start] = 0;

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(start, 0));

        while(!pq.isEmpty()){
            Position poll = pq.poll();
            int posNum = poll.posNum;
            int weight = poll.weight;

            if (check[posNum]) continue;
            check[posNum] = true;

            for (Position next : arr.get(posNum)) {
                if (dist[next.posNum] > dist[posNum] + next.weight) {
                    dist[next.posNum] = dist[posNum] + next.weight;
                    pq.offer(new Position(next.posNum, dist[next.posNum]));
                }
            }
        }

        int sum = 0;

        for (int i=1; i<=N; i++){
            if (dist[i] <= M) {
                sum += items[i];
            }
        }
        return sum;
    }
}

class Position implements Comparable<Position> {
    int posNum;
    int weight;

    Position(int posNum, int weight) {
        this.posNum = posNum;
        this.weight = weight;
    }

    @Override
    public int compareTo(Position o) {
        return weight - o.weight;
    }
}