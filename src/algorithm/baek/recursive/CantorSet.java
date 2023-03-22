package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/4779
 * 칸토어 집합
 */
public class CantorSet implements TestCase {
    static char[] arr;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int size = (int) Math.pow(3, n);
            arr = new char[size];
            for (int i = 0; i < size; i++) {
                arr[i] = '-';
            }
            recur(0, size - 1);
            bw.write(String.valueOf(arr));
            bw.write("\n");
        }
        bw.close();
    }

    public static void recur(int i, int size) {
        int nLength = size - i + 1;
        if (nLength < 3) return;
        int nSize = nLength / 3;
        for (int j = i + nSize; j < i + 2 * nSize; j++) {
            arr[j] = ' ';
        }
        recur(i, i + nSize);
        recur(i + 2 * nSize, size);
    }
}
