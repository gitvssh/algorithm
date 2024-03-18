package algorithm.baek.graph;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20303
 * 할로윈의 양아치
 * MST
 */
public class Halloween implements TestCase {
    static int N, M, K;
    static int candy[], w, cnt;
    static ArrayList<Integer> list[];
    static ArrayList<Pair> info;
    static boolean visit[];

    static class Pair {
        int w, cnt;

        public Pair(int cnt, int w) {
            this.cnt = cnt;
            this.w = w;
        }
    }

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        candy = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.valueOf(st.nextToken());
        }
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        info = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                w = 0;
                cnt = 0;
                dfs(i);
                info.add(new Pair(cnt, w));
            }
        }
        int dp[][] = new int[2][K];
        for (Pair cur : info) {
            for (int i = 0; i < K; i++) {
                if (i >= cur.cnt) {
                    dp[1][i] = Math.max(dp[0][i], dp[0][i - cur.cnt] + cur.w);
                } else {
                    dp[1][i] = dp[0][i];
                }
            }
            for (int i = 0; i < K; i++) {
                dp[0][i] = dp[1][i];
            }
        }
        System.out.println(dp[1][K - 1]);
    }

    static void dfs(int from) {
        visit[from] = true;
        w += candy[from];
        cnt += 1;
        for (int to : list[from]) {
            if (visit[to]) {
                continue;
            }
            dfs(to);
        }
    }
}