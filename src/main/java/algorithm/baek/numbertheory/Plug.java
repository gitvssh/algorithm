package algorithm.baek.numbertheory;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;

/**
 * https://www.acmicpc.net/problem/2010
 * 플러그
 * 수학
 */
@Slf4j
public class Plug implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Integer.parseInt(br.readLine())-1;
        }
        log.info("result : {}", result+1);
    }
}
