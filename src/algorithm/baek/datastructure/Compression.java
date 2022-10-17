package algorithm.baek.datastructure;

import algorithm.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;


@Slf4j
public class Compression implements TestCase {
    public int compress(String str) {
        int len = str.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == 1) {
                res++;
            } else {
                res += 1 + String.valueOf(dp[i]).length();
            }
        }
        return res;
    }

    @Override
    public void test() throws ParseException {
        int compress = compress("33(562(71(9)))");
        log.info("is start");
        log.info("compress = {}", compress);
    }
}
