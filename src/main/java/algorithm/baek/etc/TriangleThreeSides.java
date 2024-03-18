package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5073
 * 삼각형과 세 변
 */
public class TriangleThreeSides implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (a != 0 || b != 0 || c != 0) {
            if (a == b && b == c) {
                bw.write("Equilateral");
            } else if (a + b <= c || b + c <= a || c + a <= b) {
                bw.write("Invalid");
            } else if (a == b || b == c || c == a) {
                bw.write("Isosceles");
            } else {
                bw.write("Scalene");
            }
            bw.newLine();
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        bw.close();
    }
}
