package algorithm.baek.recursive;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Z implements TestCase {
    static int result = 0;
    static int n;
    static int r;
    static int c;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //2의 n승 구하기
        int size = (int) Math.pow(2, n);
        //2차원 배열에 숫자 넣기
        z(size, 0, 0, 0);
        System.out.println(result);
    }

    public static void z(int size, int x, int y, int cnt) {
        if (size == 2) {
            if (x == r && y == c) {
                result = cnt;
                return;
            }
            cnt++;
            if (x == r && y + 1 == c) {
                result = cnt;
                return;
            }
            cnt++;
            if (x + 1 == r && y == c) {
                result = cnt;
                return;
            }
            cnt++;
            if (x + 1 == r && y + 1 == c) {
                result = cnt;
                return;
            }
            cnt++;
            return;
        }
        if (r < x + size / 2 && c < y + size / 2) {
            z(size / 2, x, y, cnt);
        } else if (r < x + size / 2 && c >= y + size / 2) {
            cnt += size * size / 4;
            z(size / 2, x, y + size / 2, cnt);
        } else if (r >= x + size / 2 && c < y + size / 2) {
            cnt += size * size / 4 * 2;
            z(size / 2, x + size / 2, y, cnt);
        } else if (r >= x + size / 2 && c >= y + size / 2) {
            cnt += size * size / 4 * 3;
            z(size / 2, x + size / 2, y + size / 2, cnt);
        }
    }
}
