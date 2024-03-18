package algorithm.baek.bitmask;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;


/**
 * https://www.acmicpc.net/problem/11723
 * 집합
 * & : 비트 AND 연산, 둘 다 1일 때만 1, 나머지는 0, 수 비교 시 작은 수를 찾을 때 사용
 * | : 비트 OR 연산, 둘 중 하나라도 1이면 1, 나머지는 0, 수 비교 시 큰 수를 찾을 때 사용
 * ^ : 비트 XOR 연산, 둘이 다를 때만 1, 나머지는 0, 수 비교 시 두 수가 다를 때 사용
 * ~ : 비트 NOT 연산, 1은 0으로, 0은 1로 바꿈, 수의 부호를 바꿀 때 사용
 * << : 비트 왼쪽 시프트 연산, 2^n을 곱할 때 사용
 * >> : 비트 오른쪽 시프트 연산, 2^n을 나눌 때 사용
 * c | (1<<a) : 원소 추가, c의 a번째 비트를 1로 만듦
 * c & ~(1<<a) : 원소 제거, c의 a번째 비트를 0으로 만듦
 * c & (1<<a) : 원소 조회, 0이면 없고, 1 이상이면 있음
 * c ^ (1<<a) : 원소 토글, 켜져있으면 끄고, 꺼져있으면 켬
 */
public class BitSet implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        int bitSet = 0;

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;
            if (!cmd.equals("all") && !cmd.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }
            switch (cmd) {
                case "add":
                    bitSet |= (1 << num);
                    break;
                case "remove":
                    bitSet &= ~(1 << num);
                    break;
                case "check":
                    bw.write((bitSet & (1 << num)) > 0 ? "1" : "0");
                    bw.newLine();
                    break;
                case "toggle":
                    bitSet ^= (1 << num);
                    break;
                case "all":
                    bitSet = (1 << 21) - 1;
                    break;
                case "empty":
                    bitSet = 0;
                    break;
            }

        }
        bw.flush();
        bw.close();
    }
}
