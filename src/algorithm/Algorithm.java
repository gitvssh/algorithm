package algorithm;


import algorithm.baek.sort.Compression;

import java.io.IOException;
import java.text.ParseException;

//@Slf4j
public class Algorithm {

    public static void main(String[] args) throws IOException {
        Compression testCase = new Compression();

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
