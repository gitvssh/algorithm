package algorithm.module;

import algorithm.TestCase;

import java.io.*;
import java.math.BigInteger;
import java.text.ParseException;

public class BigInt implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger m = new BigInteger(br.readLine());
        bw.write(n.add(m) + "\n");
        bw.write(n.subtract(m) + "\n");
        bw.write(n.multiply(m) + "\n");
        bw.close();
    }
}
