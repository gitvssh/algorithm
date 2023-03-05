package algorithm.programmers.level2;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

import static java.lang.Integer.MAX_VALUE;

public class ConvertingNumber implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        System.out.println(solution(2, 5, 4));
    }

    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        for (int i = x + 1; i <= y; i++) {
            int a = MAX_VALUE;
            int b = MAX_VALUE;
            int c = MAX_VALUE;
            if (isAbove(x, i / 2) && isDivide(i, 2)) {
                a = dp[i / 2];
            }
            if (isAbove(x, i / 3) && isDivide(i, 3)) {
                b = dp[i / 3];
            }
            if (isAbove(x, i - n)) {
                c = dp[i - n];
            }
            int d = Math.min(a, Math.min(b, c));
            dp[i] = (d < MAX_VALUE) ? d + 1 : MAX_VALUE;

        }
        return (dp[y] < MAX_VALUE) ? dp[y] : -1 ;
    }

    public static boolean isDivide(int num, int divider) {
        return (num / divider > 0 && num % divider == 0);
    }

    public static boolean isAbove(int x, int num) {
        return x <= num;
    }
}
