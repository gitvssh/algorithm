package algorithm.programmers.codingtest.wello;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class Q1 implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        int n = 235386;
        for (int i = n; i < 50000000; i++) {
            // 홀수 자리수면 짝수 자리수로 만들어줌
            if (String.valueOf(i).length() % 2 != 0) {
                i *= 10;
                // 제한조건 이상이면 break
                if(i > 50000000){
                    break;
                }
            }

            String num = String.valueOf(i);
            int len = String.valueOf(i).length();
            int half = len / 2;
            // 앞부분 곱셈
            long front = 1;
            for (int j = 0; j < half; j++) {
                front *= Integer.parseInt(String.valueOf(num.charAt(j)));
            }
            // 뒷부분 곱셈
            long back = 1;
            for (int j = len; j > half; j--) {
                back *= Integer.parseInt(String.valueOf(num.charAt(j - 1)));
            }
            if (front == back) {
                System.out.println(i);
                break;
            }
        }
    }
}
