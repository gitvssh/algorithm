package algorithm;

import algorithm.baek.backtracking.ExecuteFunction;
import algorithm.baek.backtracking.NM4;
import algorithm.baek.backtracking.NQueen;
import algorithm.baek.dynamicprograming.Padoban;
import algorithm.baek.dynamicprograming.SerialSum;
import algorithm.baek.dynamicprograming.Tiles;
import algorithm.baek.dynamicprograming.fibonacciNumber;
import algorithm.baek.etc.BasketBall;
import algorithm.baek.etc.DiceGame;
import algorithm.baek.etc.MostLetters;
import algorithm.baek.etc.Start4;
import algorithm.baek.recursive.FibonacciCount;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        FibonacciCount testCase = new FibonacciCount();

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
