package algorithm;

import algorithm.baek.dividenconquer.Multiply;
import algorithm.baek.graph.KevinBacon;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        KevinBacon testCase = new KevinBacon();

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
