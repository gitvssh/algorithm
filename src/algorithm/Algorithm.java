package algorithm;

import algorithm.baek.datastructure.ChangeBasketOrder;
import algorithm.baek.dfs.Cabbage;
import algorithm.baek.etc.CheckPalindrome;
import algorithm.baek.etc.Confetti;
import algorithm.baek.etc.Score;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        Confetti testCase = new Confetti();

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
