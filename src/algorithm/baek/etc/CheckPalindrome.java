package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/10988
 * 팰린드롬인지 확인하기
 */
public class CheckPalindrome implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.println(isPalindrome(br.readLine()));
    }

    private int isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return 0;
            }
        }
        return 1;
    }
}
