package algorithm;

import algorithm.baek.backtracking.NM11;
import algorithm.baek.backtracking.NM5;
import algorithm.baek.backtracking.NM9;
import algorithm.baek.bfs.SnakeAndLadder;
import algorithm.baek.dfs.TomatoTower;
import algorithm.baek.graph.BabyShark;
import algorithm.baek.numbertheory.BaseConversion;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        NM11 testCase = new NM11();

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
