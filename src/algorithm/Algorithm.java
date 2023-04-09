package algorithm;

import algorithm.baek.datastructure.ChongChong;
import algorithm.baek.graph.MinCost;
import algorithm.baek.graph.Party;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        MinCost testCase = new MinCost();

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
