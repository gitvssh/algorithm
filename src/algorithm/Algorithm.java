package algorithm;

import algorithm.baek.bfs.EasyShortcut;
import algorithm.baek.bfs.PipeMove;
import algorithm.baek.brute.ChickenDelivery;
import algorithm.baek.brute.ThreeClosestPeople;
import algorithm.baek.dynamicprograming.Descending;
import algorithm.baek.graph.Lie;
import algorithm.baek.graph.MinCost2;
import algorithm.baek.numbertheory.Sigma;
import algorithm.baek.sort.SolvedAc;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        ThreeClosestPeople testCase = new ThreeClosestPeople();
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
