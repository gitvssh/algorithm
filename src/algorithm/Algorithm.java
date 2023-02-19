package algorithm;

import algorithm.baek.backtracking.NQueen;
import algorithm.baek.backtracking.Sudoku;
import algorithm.baek.datastructure.CyclingQueue;
import algorithm.baek.datastructure.MinHeap;
import algorithm.baek.dfs.Virus;
import algorithm.baek.dynamicprograming.IntegerTriangle;
import algorithm.baek.dynamicprograming.UpStair;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Sudoku testCase = new Sudoku();

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
