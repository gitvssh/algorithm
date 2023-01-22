package algorithm;

import algorithm.baek.backtracking.ExecuteFunction;
import algorithm.baek.backtracking.NM4;
import algorithm.baek.backtracking.NQueen;
import algorithm.baek.dynamicprograming.Padoban;
import algorithm.baek.dynamicprograming.SerialSum;
import algorithm.baek.dynamicprograming.Tiles;
import algorithm.baek.dynamicprograming.fibonacciNumber;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        SerialSum testCase = new SerialSum();

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
