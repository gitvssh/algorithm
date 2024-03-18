package algorithm.baek.string;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9935
 * 문자열 폭발
 * 문자열
 */
public class StringBomb implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        char[] result = new char[str.length()];
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            result[idx++] = str.charAt(i);
            if (idx >= bombLen && result[idx - 1] == bomb.charAt(bombLen - 1)) {
                boolean isBomb = true;
                for (int j = 0; j < bombLen; j++) {
                    if (result[idx - 1 - j] != bomb.charAt(bombLen - 1 - j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) idx -= bombLen;
            }
        }
        if (idx == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(String.valueOf(result, 0, idx));
        }

    }
}
