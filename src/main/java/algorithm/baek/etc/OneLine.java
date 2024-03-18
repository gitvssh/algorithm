package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1138
 * 한 줄로 서기
 */
public class OneLine implements TestCase {
    static int remain;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        remain = n;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int startIdx = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                startIdx = Math.min(startIdx, i);
            }
        }
        bw.write(startIdx + 1 + " ");
        decrease(arr, startIdx);

        while (true) {
            lining(n, arr, bw);
            if (remain == 0) break;
        }
        bw.flush();
        bw.close();
    }

    private static void lining(int n, int[] arr, BufferedWriter bw) throws IOException {
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                bw.write(i + 1 + " ");
                decrease(arr, i);
                break;
            }
        }
    }

    public static void decrease(int[] arr, int startIdx) {
        for (int i = 0; i < startIdx; i++) {
            if (arr[i] >= 0)
                arr[i]--;
        }
        remain--;
        arr[startIdx] = -1;
    }
}
