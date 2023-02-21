package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10798
 * 세로 읽기
 */
public class VerticalRead implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[5][];
        String str;
        for (int i = 0; i < 5; i++) {
            str = br.readLine();
            int len = str.length();
            arr[i] = new int[len];
            for (int j = 0; j < len; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j].length > i) {
                    bw.write(arr[j][i]);
                }
            }
        }
        bw.newLine();
        bw.close();
    }
}
