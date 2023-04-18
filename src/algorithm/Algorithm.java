package algorithm;

import algorithm.baek.datastructure.FindTree;
import algorithm.programmers.level1.BadKeyboard;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        BadKeyboard testCase = new BadKeyboard();

        doTest(testCase);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
