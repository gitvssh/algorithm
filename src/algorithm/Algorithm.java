package algorithm;

import algorithm.baek.etc.Ground;
import algorithm.baek.etc.MemorizeTriangle;
import algorithm.baek.etc.TriangleThreeSides;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        TriangleThreeSides testCase = new TriangleThreeSides();

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
