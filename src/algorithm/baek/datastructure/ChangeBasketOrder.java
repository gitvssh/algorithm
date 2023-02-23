package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10812
 * 바구니 순서 바꾸기
 */
public class ChangeBasketOrder implements TestCase {
    static int[] arr;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            change(start, end, k);
        }
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + " ");
        }
        bw.close();
    }

    static void change(int start, int end, int k) {
        int[] back = new int[end - k + 1];
        int[] front = new int[k - start];

        for (int i = 0; i < back.length; i++) {
            back[i] = arr[k + i];
        }
        for (int i = 0; i < front.length; i++) {
            front[i] = arr[start + i];
        }
        for (int i = 0; i < back.length; i++) {
            arr[start + i] = back[i];
        }
        for (int i = 0; i < front.length; i++) {
            arr[start+ back.length + i] = front[i];
        }
    }
}
