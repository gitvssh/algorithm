package algorithm.baek.string;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/4900
 * 7의 추가
 */
public class AddSeven implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        //숫자 -> LED표현식 -> 코드, 1~0까지 정해진 코드 존재

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        while (!line.equals("BYE")) {
            String[] arr = line.split("\\+");
            String a = arr[0];
            //주어진 문자열은 LED코드값
            //LED코드값을 숫자로 변환

            String b = arr[1].substring(0, arr[1].length() - 1);

            String s = resolve(resolve(a) + resolve(b));
            bw.write(line + s + "\n");
            line = br.readLine();
        }
        bw.flush();
        bw.close();
    }

    enum LED {
        ZERO("063", 0),
        ONE("010", 1),
        TWO("093", 2),
        THREE("079", 3),
        FOUR("106", 4),
        FIVE("103", 5),
        SIX("119", 6),
        SEVEN("011", 7),
        EIGHT("127", 8),
        NINE("107", 9);

        String code;
        int value;

        LED(String code, int value) {
            this.code = code;
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public int getValue() {
            return value;
        }
    }
    public int resolve(String code) {
        int sum = 0;
        for (int i = 0; i < code.length(); i += 3) {
            String s = code.substring(i, i + 3);
            for (LED led : LED.values()) {
                if (led.code.equals(s)) {
                    sum = sum * 10 + led.getValue();
                    break;
                }
            }
        }
        return sum;
    }

    public String resolve(int num) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(s.substring(i, i + 1));
            for (LED led : LED.values()) {
                if (led.value == n) {
                    sb.append(led.code);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
