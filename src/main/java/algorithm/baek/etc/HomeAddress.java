package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1284
 * 집 주소
 */
public class HomeAddress implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        while (!str.equals("0")) {
            int n = 2 + str.length() - 1;
            for (char a : str.toCharArray()) {
                switch (a) {
                    case '1':
                        n += 2;
                        break;
                    case '0':
                        n += 4;
                        break;
                    default:
                        n += 3;
                }
            }
            bw.write(n + "\n");
            str = br.readLine();
        }
        bw.close();
    }
}
