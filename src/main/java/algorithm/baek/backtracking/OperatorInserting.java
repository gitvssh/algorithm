package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14888
 * 연산자 끼워넣기
 */
public class OperatorInserting implements TestCase {
    public static int[] op = new int[4];
    public static int[] nums;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private void dfs(int i, int num) {
        if (i == nums.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int j = 0; j < op.length; j++) {
            if (op[j] > 0) {
                op[j]--;
                switch (j) {
                    case 0:
                        dfs(i + 1, num + nums[i]);
                        break;
                    case 1:
                        dfs(i + 1, num - nums[i]);
                        break;
                    case 2:
                        dfs(i + 1, num * nums[i]);
                        break;
                    case 3:
                        dfs(i + 1, num / nums[i]);
                        break;
                }
                op[j]++;
            }
        }
    }
}
