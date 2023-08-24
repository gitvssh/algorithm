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
            int sum = 0;
            for (int i = 0; i < a.length(); i += 3) {
                String s = a.substring(i, i + 3);
                for (LED led : LED.values()) {
                    if (led.code.equals(s)) {
                        sum = sum * 10 + Integer.parseInt(led.name());
                        break;
                    }
                }
            }

            String b = arr[1].substring(0, arr[1].length() - 1);

//            String s = Integer.toBinaryString(sum);
//            bw.write(line + s + "\n");
            line = br.readLine();
        }
        bw.flush();
        bw.close();
    }

    enum LED {
        ZERO("063"),
        ONE("010"),
        TWO("093"),
        THREE("079"),
        FOUR("106"),
        FIVE("103"),
        SIX("119"),
        SEVEN("011"),
        EIGHT("127"),
        NINE("107");

        String code;

        LED(String code) {
            this.code = code;
        }
    }
}
