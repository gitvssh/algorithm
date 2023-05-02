package algorithm;

import algorithm.programmers.level0.FactorizationProgrammers;
import algorithm.programmers.level0.ParseStringNumber;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//@Slf4j
public class Algorithm {
    public static void main(String[] args) {

//        FactorizationProgrammers testCase = new FactorizationProgrammers();
//        doTest(testCase);
        int solution = solution(30,29);
        System.out.println(solution);
    }

    static long[] arr;
    public static int solution(int balls, int share) {
        arr = new long[balls+1];
        Arrays.fill(arr, -1); // 배열 초기화
        arr[0] = 1; // 0! = 1
        arr[1] = 1; // 1! = 1
        arr[2] = 2; // 2! = 2

        return (int)(factorial(balls) / (factorial(share) * factorial(balls - share)));
    }
    public static long factorial(int n) {
        if(n == 0) return 1;
        if(arr[n] != -1) return arr[n]; // -1인 경우에만 계산 수행
        return arr[n] = n * factorial(n-1);
    }

    public static void doTest(TestCase testCase) {
        try {
            testCase.test();
        } catch (ParseException | IOException e) {
            throw new ShCodingTestException(e);
        }
    }
}
