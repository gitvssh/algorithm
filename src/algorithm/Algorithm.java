package algorithm;

import algorithm.baek.graph.ShortCut;
import algorithm.baek.numbertheory.PrimeSeqSum;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

        PrimeSeqSum testCase = new PrimeSeqSum();
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
