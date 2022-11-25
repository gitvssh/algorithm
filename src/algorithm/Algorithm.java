package algorithm;


import algorithm.baek.set.SubSetString;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        SubSetString testCase = new SubSetString();
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
