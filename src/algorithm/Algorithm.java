package algorithm;

import algorithm.baek.cumulativesum.Air;
import algorithm.baek.cumulativesum.SuperMario;
import algorithm.baek.geometry.Square;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        SuperMario testCase = new SuperMario();
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
