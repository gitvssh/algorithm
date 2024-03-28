package algorithm.baek.etc;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1252
 * 이진수 덧셈
 */
public class AddBinary implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int maxLength = Math.max(a.length(), b.length());
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            int sum = carry;
            if (i < a.length()) {
                sum += a.charAt(a.length() - 1 - i) - '0';
            }
            if (i < b.length()) {
                sum += b.charAt(b.length() - 1 - i) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        // 시작은 항상 1로 시작해야 함
        if (sb.length() == 0) {
            sb.append(0);
        }
        System.out.println(sb.reverse().toString());
    }
}
