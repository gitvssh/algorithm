package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM11 implements TestCase {
    static int n;
    static int m;
    static int arr[];
    static int result[];
    static StringBuilder sb = new StringBuilder();
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, arr[0]);
        System.out.print(sb);
    }

    public static void dfs(int depth, int beforeNum) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = -1;
        for (int i = 0; i < n; i++) {
            if(beforeNum > arr[i]) continue;
            if (before == arr[i]) continue;
            before = arr[i];
            result[depth] = arr[i];
            dfs(depth + 1, arr[i]);
        }
    }
}
