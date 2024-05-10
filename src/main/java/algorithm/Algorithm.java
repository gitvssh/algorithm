package algorithm;

import algorithm.baek.binarysearch.NumberCard;
import algorithm.baek.datastructure.PeopleInTheWork;
import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) {

        NumberCard testCase = new NumberCard();
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
