package algorithm;

import algorithm.baek.greedy.GemTheif;
import algorithm.baek.greedy.PackingShom;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        PackingShom testCase = new PackingShom();
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
