package algorithm.baek.backtracking;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1107
 * 리모컨
 */
public class RemoteController implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        //2. 고장버튼 확인
        boolean[] broken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        //3. 가장 가까운 채널 찾기
        int min = Math.abs(n - 100);
        //4. +, - 버튼으로 이동한 횟수와 비교
        for (int i = 0; i <= 1000000; i++) {
            int len = check(i, broken);
            if (len > 0) {
                int press = Math.abs(n - i);
                if (min > len + press) {
                    min = len + press;
                }
            }
        }
        //5. 출력
        System.out.println(min);

    }

    public static int check(int n, boolean[] broken) {
        if (n == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (n > 0) {
            if (broken[n % 10]) {
                return 0;
            }
            len++;
            n /= 10;
        }
        return len;
    }
}
