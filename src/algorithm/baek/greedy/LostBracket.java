package algorithm.baek.greedy;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1541
 * 잃어버린 괄호
 */
public class LostBracket implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            int temp = 0;
            String[] str2 = str[i].split("\\+");
            for (int j = 0; j < str2.length; j++) {
                temp += Integer.parseInt(str2[j]);
            }
            if (i == 0) {
                sum += temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
