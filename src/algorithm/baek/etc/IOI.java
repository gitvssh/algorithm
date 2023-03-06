package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.acmicpc.net/problem/5525
 * IOIOI
 */
public class IOI implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("IO");
        }
        sb.append("I");
        String pattern = sb.toString();
        Pattern p = Pattern.compile(pattern);
        Matcher m1 = p.matcher(s);
        int count = 0;
        int startIdx = 0;
        while (m1.find(startIdx)) {
            count++;
            startIdx = m1.start() + 1; // 다음 매칭을 위해 시작 인덱스 조정
        }
        System.out.println(count);
//        int count = 0;
//        int result = 0;
//        for (int i = 1; i < m - 1; i++) {
//            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
//                count++;
//                if (count == n) {
//                    result++;
//                    count--;
//                }
//                i++;
//            } else {
//                count = 0;
//            }
//        }
//        System.out.println(result);
    }
}
