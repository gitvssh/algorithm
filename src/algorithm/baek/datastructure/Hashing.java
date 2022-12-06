package algorithm.baek.datastructure;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;

public class Hashing implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Integer.parseInt(br.readLine());
        long m = 1234567891;
        long r = 1;
        String str = br.readLine();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (str.charAt(i) - 'a' + 1) * r;
            r = (r * 31) % m;
        }
        bw.write(sum % m + "\n");
        bw.close();
    }
}
