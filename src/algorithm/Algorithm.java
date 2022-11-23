package algorithm;


import algorithm.baek.set.NumberCard;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {
        NumberCard testCase = new NumberCard();
        ArrayList<String> list = new ArrayList<>();
        list.add("gef");
        list.add("dbf");
        list.stream().sorted().forEach((i) -> list.get(0));
        doTest(testCase);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
