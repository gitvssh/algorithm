package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Ring implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numerator = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n-1; i++) {
            int denominator = Integer.parseInt(st.nextToken());
            int gcd = gcd(numerator, denominator);
            bw.write(numerator / gcd + "/" + denominator / gcd + "\n");
        }
        bw.close();
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
