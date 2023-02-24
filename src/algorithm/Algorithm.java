package algorithm;

import algorithm.baek.datastructure.ChangeBasketOrder;
import algorithm.baek.dfs.Cabbage;
import algorithm.baek.etc.CheckPalindrome;
import algorithm.baek.etc.Score;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Cabbage testCase = new Cabbage();

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
