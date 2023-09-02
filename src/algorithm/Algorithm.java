package algorithm;

import algorithm.baek.backtracking.Teach;
import algorithm.baek.greedy.Dice;
import algorithm.baek.greedy.Ship;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        Teach testCase = new Teach();
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
