package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class SequenceNumberSum implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        for(int i : solution(4,14)) {
            System.out.println(i);
        }
    }

    public int[] solution(int num, int total) {
        int[] arr = new int[num];
        int start = (int)(Math.ceil((double)total / num) - (num / 2));
        System.out.println("start = " + start);
        for (int i = 0; i < num; i++) {
            arr[i] = i + start;
        }
        return arr;
    }
}
