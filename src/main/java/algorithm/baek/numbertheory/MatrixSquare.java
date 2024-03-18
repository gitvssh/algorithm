package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10830
 * 행렬 제곱
 * 수학, 분할 정복, 분할 정복을 이용한 거듭 제곡, 선형대수학
 */
public class MatrixSquare implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        long b = Long.valueOf(st.nextToken());
        long[][] matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                matrix[i][j++] = Integer.valueOf(st.nextToken()) % 1000;
            }
        }
        long[][] result = pow(matrix, b);
        for (long[] row : result) {
            for (long col : row) {
                bw.write(col + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public long[][] pow(long[][] matrix, long exponent) {
        if (exponent == 1) return matrix;
        long[][] result = pow(matrix, exponent / 2);
        result = multiply(result, result);
        if (exponent % 2 == 1) {
            result = multiply(result, matrix);
        }
        return result;
    }

    private long[][] multiply(long[][] result, long[][] matrix) {
        int length = result.length;
        long[][] temp = new long[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    temp[i][j] += result[i][k] * matrix[k][j];
                }
                temp[i][j] %= 1000;
            }
        }
        return temp;
    }
}
