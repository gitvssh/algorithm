package algorithm.baek.cumulativesum;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/25682
 * 체스판
 */
public class ChessBoard implements TestCase {

    static int n;
    static int m;
    static int k;
    static char[][] board;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(Math.min(minimal_board('B'), minimal_board('W')));
    }

    public static int minimal_board(char color) {
        int count = Integer.MAX_VALUE;
        int value;
        int[][] prefix_sum = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i + j) % 2 == 0) {
                    value = board[i][j] != color? 1 : 0;
                }else {
                    value = board[i][j] == color? 1 : 0;
                }
                prefix_sum[i + 1][j + 1] = prefix_sum[i][j + 1] + prefix_sum[i + 1][j] - prefix_sum[i][j] + value;
            }
        }

        for(int i = 0; i <= n - k; i++) {
            for(int j = 0; j <= m - k; j++) {
                value = prefix_sum[i + k][j + k] - prefix_sum[i + k][j] - prefix_sum[i][j + k] + prefix_sum[i][j];
                count = Math.min(count, value);
                count = Math.min(count, k * k - value);
            }
        }
        return count;
    }
}
