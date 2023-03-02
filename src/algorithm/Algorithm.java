package algorithm;

import algorithm.baek.dynamicprograming.IncreaseSequence;
import algorithm.baek.dynamicprograming.StairNumber;
import algorithm.baek.dynamicprograming.TwoNTiling2;
import algorithm.baek.dynamicprograming.Wine;
import algorithm.baek.recursive.QuadTree;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        IncreaseSequence testCase = new IncreaseSequence();

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
