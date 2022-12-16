package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class StringSort implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String zbcdefg = solution("heLLo");
        System.out.println("answer = " + zbcdefg);
    }


    public String solution(String my_string) {
        int len = my_string.length();
        char[] arr = new char[len];

        StringBuilder sb = new StringBuilder();
        String s = my_string.toLowerCase();
        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}