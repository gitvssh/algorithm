package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/11059
 * 크리 문자열
 * 누적합
 */
public class CreeString implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int length = str.length();
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(String.valueOf(str.charAt(i - 1)));
        }
        int maxLength = length % 2 == 0 ? length : length - 1;
        maxLength /= 2;

        boolean found = false;
        while (maxLength > 0 && !found) {
            for (int i = 0; i <= length - 2 * maxLength; i++) {
                if(i == 0 && length % 2 != 0) i++;
                int left = sum[i + maxLength] - sum[i];
                int right = sum[i + 2 * maxLength] - sum[i + maxLength];
                if (left == right) {
                    bw.write(String.valueOf(maxLength * 2));
                    bw.flush();
                    bw.close();
                    found = true;
                    break;
                }
            }
            if (!found) maxLength--;
        }
        if (!found) {
            bw.write("0"); // 최대 부분 문자열 길이가 0인 경우
            bw.flush();
            bw.close();
        }
    }
}