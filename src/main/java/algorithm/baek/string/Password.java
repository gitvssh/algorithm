package algorithm.baek.string;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.acmicpc.net/problem/4659
 * 비밀번호 발음하기
 * 문자열
 */
public class Password implements TestCase {
    String rule = "^[^aeiou]+$|[aeiou]{3,}|[^aeiou]{3,}|([^eo])\\1+";
    Pattern pattern = Pattern.compile(rule);

    @Override
    public void test() throws ParseException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        while (!str.equals("end")) {
            if (isPassword(str)) {
                bw.write("<" + str + "> is acceptable.\n");
            } else {
                bw.write("<" + str + "> is not acceptable.\n");
            }
            str = br.readLine();
        }
        bw.flush();
        bw.close();
    }

    private boolean isPassword(String str) {
        Matcher matcher4 = pattern.matcher(str);
        if (matcher4.find()) {
            return false;
        }
        return true;
    }
}
