package algorithm;

import algorithm.baek.sort.Statistics;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) throws IOException {
        Statistics statistics = new Statistics();
        doTest(statistics);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
