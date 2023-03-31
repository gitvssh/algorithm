package algorithm;

import algorithm.baek.bfs.SnakeAndLadder;
import algorithm.baek.dfs.TomatoTower;
import algorithm.baek.numbertheory.BaseConversion;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        BaseConversion testCase = new BaseConversion();

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
