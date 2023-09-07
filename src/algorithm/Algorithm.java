package algorithm;

import algorithm.baek.backtracking.Teach;
import algorithm.baek.datastructure.Josephus;
import algorithm.baek.datastructure.SerialNumber;
import algorithm.baek.greedy.Dice;
import algorithm.baek.greedy.Ship;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        SerialNumber testCase = new SerialNumber();
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
