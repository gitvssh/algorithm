package algorithm.baek.numbertheory;

import algorithm.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * https://www.acmicpc.net/problem/1373
 * 2진수 8진수
 */
public class BinaryToOctal implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binaryString = br.readLine();
        int binaryLength = binaryString.length();
        int remainder = binaryLength % 3;
        String padding = "";
        if (remainder == 1) {
            padding = "00";
        } else if (remainder == 2) {
            padding = "0";
        }
        binaryString = padding + binaryString;
        binaryLength = binaryString.length();
        StringBuilder octalString = new StringBuilder();
        for (int i = 0; i < binaryLength; i += 3) {
            String binarySubString = binaryString.substring(i, i + 3);
            int octalDigit = Integer.parseInt(binarySubString, 2);
            octalString.append(octalDigit);
        }
        System.out.println(octalString.toString());
    }
}
