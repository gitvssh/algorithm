package algorithm.baek.string;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1032
 * 명령 프롬프트
 * 문자열, 구현
 */
public class CommandPrompt implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] fileNames = new String[n];
        for (int i = 0; i < n; i++) {
            fileNames[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileNames[0].length(); i++) {
            char c = fileNames[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < n; j++) {
                if (c != fileNames[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }
        System.out.println(sb.toString());
    }
}
