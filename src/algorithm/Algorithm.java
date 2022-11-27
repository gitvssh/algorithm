package algorithm;

import algorithm.leetcode.daily.ValidParentheses;
import algorithm.leetcode.numbertheory.MultipleFactors;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        MultipleFactors testCase = new MultipleFactors();
        doTest(testCase);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
