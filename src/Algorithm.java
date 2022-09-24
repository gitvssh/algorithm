import algorithm.TestCase;
import algorithm.programmers.codingtest.kakao.Kakao2;

import java.text.ParseException;


public class Algorithm {
    public static void main(String[] args) {
        TestCase testCase = new Kakao2();
        try {
            testCase.test();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
